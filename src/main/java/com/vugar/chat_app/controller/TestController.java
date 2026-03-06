package com.vugar.chat_app.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String test(){
        return "Secure endpoint works";
    }
}