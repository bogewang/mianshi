package cn.bgw.sss1.kafka.kafkademo.message;

import lombok.Data;

@Data
public class Demo01Message {
    public static final String TOPIC = "DEMO_01";
    /**
     * 消息编号;
     */
    private Integer id;
}
