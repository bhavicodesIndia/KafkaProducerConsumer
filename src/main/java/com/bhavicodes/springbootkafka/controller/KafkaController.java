package com.bhavicodes.springbootkafka.controller;

import com.bhavicodes.springbootkafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {

    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/check/health")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok("The  server is up and running");
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic : "+message);
    }

}
