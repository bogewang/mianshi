package cn.bgw.sss1.activemq.consumer;

import cn.bgw.sss1.activemq.message.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @JmsListener(destination = Demo01Message.QUEUE)
    public void onMessage(Demo01Message msg){
        logger.info("[onMessage][线程编号{}, 消息内容: {}]", Thread.currentThread().getId(), msg);
    }
}
