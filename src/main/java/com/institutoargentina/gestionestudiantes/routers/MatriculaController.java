
package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.institutoargentina.gestionestudiantes.modelo.Matricula;
import com.institutoargentina.gestionestudiantes.servicio.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping
    public List<Matricula> listar() {
        return matriculaService.listar();
    }

    @GetMapping("/{id}")
    public Matricula obtenerPorId(@PathVariable Integer id) {
        return matriculaService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<Matricula> registrar(
            @RequestBody Matricula matricula) {

        Matricula creada = matriculaService.registrar(matricula);

        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(
            @PathVariable Integer id,
            @RequestBody Matricula matricula) {

        return matriculaService.actualizar(id, matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {

        matriculaService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarError(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
