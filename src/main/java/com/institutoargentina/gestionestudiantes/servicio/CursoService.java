package com.institutoargentina.gestionestudiantes.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institutoargentina.gestionestudiantes.dao.CursoRepository;
import com.institutoargentina.gestionestudiantes.modelo.Curso;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso obtenerPorId(Integer id) {
        return cursoRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Curso no encontrado con ID: " + id));
    }

    @Transactional
    public Curso registrar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public Curso actualizar(Integer id, Curso datos) {
        Curso existente = obtenerPorId(id);

        existente.setNombre(datos.getNombre());
        existente.setDescripcion(datos.getDescripcion());
        existente.setCreditos(datos.getCreditos());
        existente.setCiclo(datos.getCiclo());
        existente.setHorasSemanales(datos.getHorasSemanales());
        existente.setIdDocente(datos.getIdDocente());
        existente.setCarrera(datos.getCarrera());

        return cursoRepository.save(existente);
    }

    @Transactional
    public void eliminar(Integer id) {
        Curso existente = obtenerPorId(id);
        cursoRepository.delete(existente);
    }
}