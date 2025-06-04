package com.example.elearner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elearner")
public class HomeController {

    @GetMapping("/register")
    public ResponseEntity<String> register(){
        return ResponseEntity.ok("Hello World");
    }
}
