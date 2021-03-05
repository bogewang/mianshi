package cn.bgw.sss1.rabbitmq.message;

import lombok.Data;

import java.io.Serializable;
@Data
public class Demo02Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_02";

    public static final String EXCHANGE = "EXCHANGE_DEMO_02";

    public static final String ROUTING_KEY = "#.yu.nai";

    /**
     * 编号
     */
    private Integer id;
}
