package cn.bgw.sss1.rocketmq.producer.controller;

import cn.bgw.sss1.rocketmq.producer.message.Demo01Message;
import cn.bgw.sss1.rocketmq.producer.message.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/demo01")
public class Demo01Controller {

    @Autowired
    private MySource mySource;

    @GetMapping("/send")
    public boolean send(){
        // 1 创建message
        Demo01Message msg = new Demo01Message();
        msg.setId(new Random().nextInt());
        // 2 创建spring message 对象;
        Message<Demo01Message> springMessage = MessageBuilder.withPayload(msg).build();
        // 3 发送消息
        return mySource.demo01Output().send(springMessage);
    }
}
