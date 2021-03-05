package cn.bgw.sss1.rabbitmq.config;

import cn.bgw.sss1.rabbitmq.message.Demo01Message;
import cn.bgw.sss1.rabbitmq.message.Demo02Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.*;
import sun.nio.cs.FastCharsetProvider;

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

    public static class TopicExchangeDemoConfiguration{
        // 创建队列
        @Bean
        public Queue demo02Queue(){
            return new Queue(Demo02Message.QUEUE, true, false, false);
        }

        @Bean
        // 创建topic 交换机
        public TopicExchange demo02Exchange(){
                return new TopicExchange(Demo02Message.EXCHANGE, true, false);
        }

        // 创建绑定
        @Bean
        public Binding demo02Binding(){
            return BindingBuilder.bind(demo02Queue()).to(demo02Exchange()).with(Demo02Message.ROUTING_KEY);
        }
    }

}
