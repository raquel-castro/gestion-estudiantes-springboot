package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.institutoargentina.gestionestudiantes.modelo.Persona;
import com.institutoargentina.gestionestudiantes.servicio.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    @GetMapping("/{id}")
    public Persona obtenerPorId(@PathVariable Integer id) {
        return personaService.obtenerPorId(id);
    }
}