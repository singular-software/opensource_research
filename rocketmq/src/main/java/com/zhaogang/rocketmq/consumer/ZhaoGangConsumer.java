package com.zhaogang.rocketmq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author weiguo.liu
 * @date 2020/10/9
 * @description
 */
@Component("zhaoGangConsumer")
@RocketMQMessageListener(consumerGroup = "zg_consumer_gp", topic = "test_topic")
public class ZhaoGangConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("consumer: get message[ " + message + " ]");
    }
}
