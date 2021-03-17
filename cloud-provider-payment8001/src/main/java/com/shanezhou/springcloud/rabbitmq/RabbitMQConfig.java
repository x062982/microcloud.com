//package com.shanezhou.springcloud.rabbitmq;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author ShaneZhou
// * @since 2020/9/25 周五
// */
//@Configuration
//public class RabbitMQConfig {
//
//    public static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";
//
//    public static final String QUEUE_NAME = "spring-boot";
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, false);
//    }
//
//    @Bean
//    public TopicExchange topicExchange() {
//        return new TopicExchange(TOPIC_EXCHANGE_NAME);
//    }
//
//    @Bean
//    public Binding binding(Queue queue, TopicExchange topicExchange) {
//        return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
//    }
//
//    @Bean
//    public MessageListenerAdapter listenerAdapter(RabbitMQReceiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//    @Bean
//    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                                    MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setMessageListener(listenerAdapter);
//        container.setQueueNames(QUEUE_NAME);
//        return container;
//    }
//}
