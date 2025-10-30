package com.bhavicodes.springbootkafka.kafka;

import com.bhavicodes.springbootkafka.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;
    private Logger  LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ResponseEntity<String> sendMessage(User user) {

        Message<User> message=
                MessageBuilder.
                withPayload(user).setHeader(KafkaHeaders.TOPIC,"KafkaJsonTopic")
                .build();

        kafkaTemplate.send("KafkaJsonTopic",user);
        LOGGER.info(String.format("send message via json kafka producer : " +user.toString()) );
        return ResponseEntity.ok("message sent from Kafka " + user.toString());
    }
}
