package com.bhavicodes.springbootkafka.kafka;

import com.bhavicodes.springbootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    // consumer method acts as a subscriber and it has subcscribe to the topic 'KafkaTopic'
    // whenever kafkaproducer will send a message to kafka topic then the consumer
    // i.e. kafka consumer it will recieve the method from the kafkaTopic - topic
    @KafkaListener(topics = "kafkaTopic", groupId = "kafkagroup")
    public void consumer(String message)
    {
        LOGGER.info(String.format("Received Message: %s", message));
    }

    @KafkaListener(topics = "KafkaJsonTopic" , groupId = "kafkagroup")
    public void jsonConsumer(User user)
    {
        LOGGER.info(String.format("Received Message json format : "+ user.toString()));
    }
}
