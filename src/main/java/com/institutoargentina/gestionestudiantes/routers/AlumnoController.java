
package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.institutoargentina.gestionestudiantes.modelo.Alumno;
import com.institutoargentina.gestionestudiantes.servicio.EstudianteService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final EstudianteService estudianteService;

    public AlumnoController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> listar() {
        return ResponseEntity.ok(estudianteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Alumno> registrar(@RequestBody Alumno alumno) {
        Alumno nuevo = estudianteService.registrar(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(
            @PathVariable Integer id,
            @RequestBody Alumno alumno) {
        return ResponseEntity.ok(estudianteService.actualizar(id, alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarError(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
