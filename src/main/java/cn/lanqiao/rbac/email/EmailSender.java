package cn.lanqiao.rbac.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    @Autowired
    JavaMailSender javaMailSender;
    /**
     * 发送消息
     * @param to 对⽅邮箱
     * @param text 发送内容
     */
    @Async
    public void sendMessage(String to,String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发送给谁
        simpleMailMessage.setFrom("643359474@qq.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("这是⼀封测试邮件");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}