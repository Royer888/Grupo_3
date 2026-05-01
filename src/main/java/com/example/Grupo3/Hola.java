package com.example.Grupo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Hola {
    @GetMapping("/hola")
    public String hola() {
        return "Hola somos el grupo Grupo3";
    }
}
