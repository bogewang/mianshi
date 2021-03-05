package cn.bgw.sss1.rabbitmq;

import cn.bgw.sss1.rabbitmq.producer.Demo01Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Demo01ProducerTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private Demo01Producer producer;
    @Test
    public void testSyncSend() throws InterruptedException {
        int id = (int)(System.currentTimeMillis()/1000);
        producer.syncSend(id);
        logger.info("[testSyncSend][发送编号：[{}] 发送成功]", id);
        new CountDownLatch(1).await();
    }
    @Test
    public void testSyncSendDefault() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        producer.syncSendDefault(id);
        logger.info("[tesSyncSendDefault][发送编号：[{}] 发送成功]", id);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int)(System.currentTimeMillis() / 1000);
        producer.asyncSend(id).addCallback(new ListenableFutureCallback<Void>() {
            @Override
            public void onFailure(Throwable e) {
                logger.info("[testAsyncSend][发送编码: [{}]], 发送异常", id, e);
            }

            @Override
            public void onSuccess(Void aVoid) {
                logger.info("[testAsyncSend][发送编码: [{}]], 发送成功", id);
            }
        });

        logger.info("[testAsyncSend][发送编号:[{}]], 调用完成", id);

        new CountDownLatch(1).await();
    }
}
