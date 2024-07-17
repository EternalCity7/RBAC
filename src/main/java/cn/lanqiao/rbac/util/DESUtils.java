package cn.lanqiao.rbac.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * @author david
 */
public class DESUtils {

    public static final String KEY_DES = "DES";
    public static final String KEY = "TY5YIGWFMWK3MOW4Y45KRWW382X3U8NI";

    /**
     * 加密操作
     * */
    public static String encrypt(String text) {
        return byte2hex(encrypt(text.getBytes(StandardCharsets.UTF_8), KEY.getBytes(StandardCharsets.UTF_8)));
    }
    /**
     * 解密操作
     * */
    public static String decrypt(String text) {
        try {
            return new String(decrypt(hex2byte(text.getBytes(StandardCharsets.UTF_8)), KEY.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException("解密[" + text + "]发生异常:" + e.getMessage(), e);
        }
    }


    private static byte[] encrypt(byte[] data, byte[] key) {
        byte[] bytes = null;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(KEY_DES);
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(key)), new SecureRandom());
            bytes = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static byte[] decrypt(byte[] data, byte[] key) {
        byte[] bytes = null;
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(KEY_DES);
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance(KEY_DES).generateSecret(new DESKeySpec(key)), new SecureRandom());
            bytes = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (byte value : b) {
            stmp = (Integer.toHexString(value & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }

    public static void main(String[] args) throws Exception {
        String msg = "123456";
        String encrypt = DESUtils.encrypt(msg);
        System.out.println("DES加密:" + encrypt);

        String decrypt = DESUtils.decrypt(encrypt);
        System.out.println("DES解密：" + decrypt);
    }
}