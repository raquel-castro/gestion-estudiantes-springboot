
package com.institutoargentina.gestionestudiantes.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institutoargentina.gestionestudiantes.dao.AlumnoRepository;
import com.institutoargentina.gestionestudiantes.modelo.Alumno;

@Service
public class EstudianteService {

    private final AlumnoRepository alumnoRepository;

    public EstudianteService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerPorId(Integer id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Alumno no encontrado con ID: " + id));
    }

    @Transactional
    public Alumno registrar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Transactional
    public Alumno actualizar(Integer id, Alumno datos) {
        Alumno existente = obtenerPorId(id);

        existente.setPersona(datos.getPersona());
        existente.setEstadoAcademico(datos.getEstadoAcademico());
        existente.setCarrera(datos.getCarrera());
        existente.setCicloIngreso(datos.getCicloIngreso());
        existente.setFechaIngreso(datos.getFechaIngreso());
        existente.setFechaTermino(datos.getFechaTermino());
        existente.setTurnoActual(datos.getTurnoActual());
        existente.setCondicionAlumno(datos.getCondicionAlumno());

        return alumnoRepository.save(existente);
    }

    @Transactional
    public void eliminar(Integer id) {
        Alumno existente = obtenerPorId(id);
        alumnoRepository.delete(existente);
    }
}
