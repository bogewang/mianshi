package cn.bgw.sss1.rabbitmq.consumer;

import cn.bgw.sss1.rabbitmq.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
@RabbitListener(queues = Demo01Message.QUEUE)
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RabbitHandler
    public void onMessage(Demo01Message message){
        logger.info("[onMessage][线程编号: {}, 消息内容: {}]", Thread.currentThread().getId(), message);
    }
}
