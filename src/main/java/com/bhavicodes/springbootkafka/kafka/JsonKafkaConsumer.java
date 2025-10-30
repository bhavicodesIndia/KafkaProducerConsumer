package com.bhavicodes.springbootkafka.kafka;


import com.bhavicodes.springbootkafka.payload.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

private final Logger LOGGER = (Logger) LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "KafkaJsonTopic" , groupId = "kafkaGroup")
    public void consumeJson(User user)
    {
     LOGGER.info(String.format("Receive message from topic : %s", user));

    }

}
