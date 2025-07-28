package com.gestortareas.gestor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TareaController {

    @GetMapping("/")
    public String hola() {
        return "Bienvenido al Gestor de Tareas";
    }
}
