package com.cognizant.paymentservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/pay")
    @CircuitBreaker(name = "paymentCircuitBreaker", fallbackMethod = "paymentFallback")
    public String processPayment() {
        return restTemplate.getForObject("http://localhost:9999/slow-api", String.class);
    }

    public String paymentFallback(Exception e) {
        System.out.println("Fallback triggered due to: " + e.getMessage());
        return "Payment service is currently unavailable. Please try again later.";
    }
}
