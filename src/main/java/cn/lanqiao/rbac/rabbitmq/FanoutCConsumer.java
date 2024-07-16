package cn.lanqiao.rbac.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
@RabbitListener(queues = "fanout.c")
public class FanoutCConsumer {
    @RabbitHandler
    public void listen(String msg){
        System.out.println("收到");
    }
}
