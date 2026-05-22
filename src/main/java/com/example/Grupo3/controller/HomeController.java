package com.example.Grupo3.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Hidden // Esto oculta este controlador de la lista de Swagger para no hacer bulto
public class HomeController {

    @GetMapping("/")
    public RedirectView inicio() {
        // Redirige automáticamente a la página de Swagger
        return new RedirectView("/swagger-ui/index.html");
    }
}