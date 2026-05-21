package com.example.Grupo3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "SISTEMA VSIAF - Grupo 3 equipo alfa buena maravilla onda dinamita escuadrón lobo",
                version = "1.0",
                description = """
        Sistema CRUD desarrollado en Spring Boot.

        INTEGRANTES:
        • Cristian David Paco Bravo
        • Roger Flores Choque
        • Jorge Roman Ochoa Saldaña

        Materia: Tecnologías Emergentes Gestión 2026
        """
        )
)
public class Grupo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Grupo3Application.class, args);
    }
}