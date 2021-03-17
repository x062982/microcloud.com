//package com.shanezhou.springcloud.rabbitmq;
//
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @author ShaneZhou
// * @since 2020/9/25 周五
// */
//@Component
//public class RabbitMQReceiver {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public void receiveMessage(String message) {
//        System.out.println("message: " + message);
//        latch.countDown();
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//}
