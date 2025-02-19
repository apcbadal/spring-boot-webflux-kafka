package com.example.webflux.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserEventConsumer {
    @KafkaListener(topics = "user-events", groupId = "user-group")
    public void listenUserEvents(String message) {
        System.out.println("Received Kafka message: " + message);
    }
}
