package com.institutoargentina.gestionestudiantes.routers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Matricula registrar(@RequestBody Matricula matricula) {
        return matriculaService.registrar(matricula);
    }

    @PutMapping("/{id}")
    public Matricula actualizar(
            @PathVariable Integer id,
            @RequestBody Matricula matricula) {
        return matriculaService.actualizar(id, matricula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        matriculaService.eliminar(id);
    }
}