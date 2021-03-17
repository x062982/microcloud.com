//package com.shanezhou.springcloud.rabbitmq;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author ShaneZhou
// * @since 2020/9/25 周五
// */
//@Component
//public class RabbitMQRunner implements CommandLineRunner {
//
//    private final RabbitMQReceiver receiver;
//    private final RabbitTemplate rabbitTemplate;
//
//    public RabbitMQRunner(RabbitMQReceiver receiver, RabbitTemplate rabbitTemplate) {
//        this.receiver = receiver;
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_NAME,
//                "foo.bar.baz", "Hello World RabbitMQ!");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//
//    }
//}
