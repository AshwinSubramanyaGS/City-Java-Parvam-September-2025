package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")

public class GreetController {
    @GetMapping("/greet/{name}")
    public String greet(
        @PathVariable String name,
        @RequestParam(defaultValue = "0") int age){
        return "Hello "+name+ " you are "+age+" years old" ;
    }
}
