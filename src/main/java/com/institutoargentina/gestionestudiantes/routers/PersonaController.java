
package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.institutoargentina.gestionestudiantes.schemas.PersonaDTO;
import com.institutoargentina.gestionestudiantes.servicio.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Listar personas mediante DTO
    @GetMapping
    public ResponseEntity<List<PersonaDTO>> listar() {

        List<PersonaDTO> personas = personaService.listar()
                .stream()
                .map(PersonaDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(personas);
    }

    // Buscar persona por ID mediante DTO
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> obtenerPorId(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                PersonaDTO.fromEntity(personaService.obtenerPorId(id))
        );
    }
}
