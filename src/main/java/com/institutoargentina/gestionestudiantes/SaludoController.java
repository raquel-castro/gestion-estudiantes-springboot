package com.institutoargentina.gestionestudiantes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/api/saludo")
    public String saludo() {
        return "Servicio REST funcionando correctamente - Gestion de Estudiantes";
    }
}