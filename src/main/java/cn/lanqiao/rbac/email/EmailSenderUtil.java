package cn.lanqiao.rbac.email;

import cn.lanqiao.rbac.util.DESUtils;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmailSenderUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String toMail) {
        try {
            //使⽤des加密⽣成激活码，加密内容为 toMail+now
            String activeCode = DESUtils.encrypt(toMail);
            String eMail=toMail.split("-", 2)[0];
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //是否发送的邮件是富⽂本（附件，图⽚，html等）
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom("643359474@qq.com");
            messageHelper.setTo(eMail);
            messageHelper.setSubject("激活邮件-测试");
            //若设置false,则显示原始html代码,⽆效果
            messageHelper.setText(
                    "<p>\n" +
                            " <b>" + eMail + "</b>, 您好!\n" +
                            "</p>\n" +
                            "<p>这是⼀封激活邮件, " +
                            "<a href=\"http://localhost:8080/user/activation/"+activeCode+"\">请点击 </a>" +
            "激活您的账号!</p>", true);
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}