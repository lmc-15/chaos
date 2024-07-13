package com.dev.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Demo class
 *
 * @author liumc
 * @date 2018/11/14
 */
@Component
public class KafkaProducer {
    private final KafkaTemplate kafkaTemplate;

    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * kafka生产者
     *
     * @param topic
     * @param massage
     */
    public boolean sendMsg(String topic, Object massage) {
        /** 返回kafka是否返回成功*/
        boolean result = !kafkaTemplate.send(topic, massage).isDone();
        return result;
    }
}
