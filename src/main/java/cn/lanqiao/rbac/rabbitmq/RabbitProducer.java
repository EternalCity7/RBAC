package cn.lanqiao.rbac.rabbitmq;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDemoQueue() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("[demoQueue] send msg: " + dateString);
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("demoQueue", dateString);
    }
    public void sendFanout() {
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("[fanout] send msg:" + dateString);
        // 注意 第一个参数是交换机的名称 ，第二个参数是routerKey不用管空着就可以，第三个是要发送的消息
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", dateString);
    }
    public void sendDirect(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println("[fanout] send msg:" + dateString);
        // 注意 第一个参数是交换机的名称 ，第二个参数是routerKey不用管空着就可以，第三个是要发送的消息
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", dateString);
    }
}