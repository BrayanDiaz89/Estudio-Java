package com.devsenior.bdiaz.rest.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String sayHelloWorld(){
        return "Hello world";
    }

    @GetMapping("/name")
    public String sayHelloToMe(@RequestParam("nombre") String name,
                               @RequestParam(value = "apellido", required = false, defaultValue = "Smith") String lastName){
        return String.format("Bienvenido %s %s!", name, lastName);
    }
    @GetMapping("/name2/{name}")
    public String sayHelloToMe(@PathVariable("name") String name){
        return String.format("Bienvenido %s again!", name);
    }

    @GetMapping("/nameJson/{name}")
    public Map<String, Object> satHelloToMe(@PathVariable String name){
        var value = String.format("Bienvenido %s again", name);
        return Map.of("Message", value, "edad", 5);
    }
}
