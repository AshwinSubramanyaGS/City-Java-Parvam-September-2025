package com.gamingclub.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String authenticate(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return "fake-jwt-token";
        }
        throw new RuntimeException("Invalid credentials");
    }
}