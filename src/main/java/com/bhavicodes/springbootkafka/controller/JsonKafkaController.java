package com.bhavicodes.springbootkafka.controller;

import com.bhavicodes.springbootkafka.kafka.JsonKafkaProducer;
import com.bhavicodes.springbootkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/kafka/user")
public class JsonKafkaController {

    public JsonKafkaProducer kafkaProducer;

    public JsonKafkaController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestBody User message){

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().body("Message sent successfully : { " + message.toString() + " }");
    }

}
