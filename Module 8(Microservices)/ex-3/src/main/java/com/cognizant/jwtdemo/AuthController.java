package com.cognizant.jwtdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth/login")
    public String login(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String secureEndpoint() {
        return "Access granted to secure endpoint";
    }
}
