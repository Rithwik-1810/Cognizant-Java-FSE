package com.cognizant.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient webClient;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Boolean userExists = webClient.get()
                .uri("http://localhost:8081/users/" + order.getUserId())
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return reactor.core.publisher.Mono.just(true);
                    } else {
                        return reactor.core.publisher.Mono.just(false);
                    }
                }).block();

        if (Boolean.TRUE.equals(userExists)) {
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
