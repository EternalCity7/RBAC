package cn.lanqiao.rbac.rabbitmq;

import cn.lanqiao.rbac.email.EmailSenderUtil;
import cn.lanqiao.rbac.util.Result;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static cn.lanqiao.rbac.util.Result.success;

@Component
@RabbitListener(queues = "directQueue")
public class RabbitConsumer {
    @Autowired
    EmailSenderUtil emailSenderUtil;

    @RabbitHandler
    public void sendMail(String toMail){
        emailSenderUtil.sendEmail(toMail);
    }
}