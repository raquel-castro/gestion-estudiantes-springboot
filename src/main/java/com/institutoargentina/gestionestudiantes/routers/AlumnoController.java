
package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.institutoargentina.gestionestudiantes.modelo.Alumno;
import com.institutoargentina.gestionestudiantes.schemas.AlumnoDTO;
import com.institutoargentina.gestionestudiantes.servicio.EstudianteService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final EstudianteService estudianteService;

    public AlumnoController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // Listar alumnos mediante DTO
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> listar() {

        List<AlumnoDTO> alumnos = estudianteService.listar()
                .stream()
                .map(AlumnoDTO::fromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(alumnos);
    }

    // Buscar alumno por ID mediante DTO
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerPorId(
            @PathVariable Integer id) {

        Alumno alumno = estudianteService.obtenerPorId(id);

        return ResponseEntity.ok(AlumnoDTO.fromEntity(alumno));
    }

    // Registrar alumno
    @PostMapping
    public ResponseEntity<AlumnoDTO> registrar(
            @RequestBody Alumno alumno) {

        Alumno nuevo = estudianteService.registrar(alumno);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AlumnoDTO.fromEntity(nuevo));
    }

    // Actualizar alumno
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizar(
            @PathVariable Integer id,
            @RequestBody Alumno alumno) {

        Alumno actualizado = estudianteService.actualizar(id, alumno);

        return ResponseEntity.ok(AlumnoDTO.fromEntity(actualizado));
    }

    // Eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer id) {

        estudianteService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarError(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
