package com.example.demo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class JsonReadController {

    // Define a simple DTO (Data Transfer Object)
    public static class UserRequest {
        private String name;
        private int age;

        // Getters and Setters (required for JSON mapping)
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    // Handle POST with JSON body
    @PostMapping("/user")
    public String createUser(@RequestBody UserRequest userRequest) {
        return "Received user: " + userRequest.getName() + ", age: " + userRequest.getAge();
    }
}
