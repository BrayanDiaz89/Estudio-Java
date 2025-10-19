package com.platzi.bdiaz.JanniePlay.controller;

import com.platzi.bdiaz.JanniePlay.service.ai.JanniePlayAIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloAI")
public class HelloController {
    private final JanniePlayAIService aiService;

    public HelloController(JanniePlayAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public String hello(){
        return this.aiService.generateGreeting();
    }

}
