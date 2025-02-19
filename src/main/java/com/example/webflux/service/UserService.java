package com.example.webflux.service;

import com.example.webflux.producer.UserEventProducer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.example.webflux.repository.UserRepository;
import com.example.webflux.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserEventProducer userEventProducer;


    public UserService(UserRepository userRepository, UserEventProducer userEventProducer) {
        this.userRepository = userRepository;
        this.userEventProducer = userEventProducer;
    }

    public Mono<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .doOnNext(user -> userEventProducer.sendUserEvent("User retrieved: " + user.getEmail()));
    }
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

}
