package com.igor.bajobs.bajobs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Index {

    @GetMapping
    public String hello() {
        return "Hello! Welcome to BaJobs API!";
    }
}
