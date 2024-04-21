package com.example.kafkademo.controllers;

import com.example.kafkademo.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return "Ok";
    }
}
