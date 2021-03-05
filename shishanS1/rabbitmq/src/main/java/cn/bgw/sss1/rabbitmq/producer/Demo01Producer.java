package cn.bgw.sss1.rabbitmq.producer;

import cn.bgw.sss1.rabbitmq.message.Demo01Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Demo01Producer {
    @Autowired
    private RabbitTemplate template;


    public void syncSend(Integer id){
        Demo01Message msg = new Demo01Message();
        msg.setId(id);
        template.convertAndSend(Demo01Message.EXCHANGE, Demo01Message.ROUTING_KEY, msg);
    }

    public void syncSendDefault(Integer id){
        Demo01Message msg = new Demo01Message();
        msg.setId(id);
        template.convertAndSend(Demo01Message.QUEUE, msg);
    }

    @Async
    public ListenableFuture<Void> asyncSend(Integer id){
        try {
            this.syncSend(id);
            return AsyncResult.forValue(null);
        } catch (Exception e){
            return AsyncResult.forExecutionException(e);
        }
    }
}
