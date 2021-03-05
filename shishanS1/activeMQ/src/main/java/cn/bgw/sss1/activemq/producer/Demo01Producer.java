package cn.bgw.sss1.activemq.producer;

import cn.bgw.sss1.activemq.message.Demo01Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class Demo01Producer {
    @Autowired
    private JmsMessagingTemplate template;

    public void syncSend(Integer id){
        Demo01Message msg = new Demo01Message();
        msg.setId(id);
        template.convertAndSend(Demo01Message.QUEUE, msg);
    }

    @Async
    public ListenableFuture<Void> asyncSend(Integer id){
        try {
            syncSend(id);
            // 返回成功的Future;
            return AsyncResult.forValue(null);
        } catch (Exception e) {
            // 返回异常的Future;
            return AsyncResult.forExecutionException(e);
        }
    }
}
