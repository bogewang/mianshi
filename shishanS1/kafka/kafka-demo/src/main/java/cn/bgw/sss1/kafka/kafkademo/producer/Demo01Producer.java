package cn.bgw.sss1.kafka.kafkademo.producer;

import cn.bgw.sss1.kafka.kafkademo.message.Demo01Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

@Component
public class Demo01Producer {
    @Resource
    private KafkaTemplate<Object, Object> template;

    public SendResult syncSend(Integer id) throws ExecutionException, InterruptedException {
        // 1.创建消息;
        Demo01Message message = new Demo01Message();
        message.setId(id);
        // 2.同步发送消息, 调用get,阻塞实现同步效果;
        return template.send(Demo01Message.TOPIC, message).get();
    }

    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id){
        Demo01Message message = new Demo01Message();
        message.setId(id);
        // 异步发送消息;
        return template.send(Demo01Message.TOPIC, message);
    }

}
