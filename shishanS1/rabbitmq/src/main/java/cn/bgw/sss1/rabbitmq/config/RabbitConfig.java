package cn.bgw.sss1.rabbitmq.config;

import cn.bgw.sss1.rabbitmq.message.Demo01Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;

@Configuration
public class RabbitConfig {
    /**
     * Direct Exchange 示例的配置类
     */
    public static class DirectExchangeDemoConfiguration{
        // 创建 Queue
        @Bean
        public Queue demo01Queue(){
            return new Queue(Demo01Message.QUEUE, true, false, false);
        }

        /**
         * 创建 Direct Exchange
         * @return
         */
        @Bean
        public DirectExchange demo01Exchange(){
            return new DirectExchange(Demo01Message.EXCHANGE, true, false);
        }

        // 创建 Binding
        @Bean
        public Binding demo01Binding(){
            return BindingBuilder.bind(demo01Queue()).to(demo01Exchange()).with(Demo01Message.ROUTING_KEY);
        }
    }

}
