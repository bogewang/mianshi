package cn.bgw.sss1.activemq.message;

import lombok.Data;

import java.io.Serializable;
@Data
public class Demo01Message implements Serializable {

    public static final String QUEUE = "QUEUE_DEMO_01";
    private Integer id;
}
