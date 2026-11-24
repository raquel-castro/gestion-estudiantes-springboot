
package com.institutoargentina.gestionestudiantes.servicio;

import java.util.List;
import com.institutoargentina.gestionestudiantes.excepciones.MatriculaNoEncontradaException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institutoargentina.gestionestudiantes.dao.MatriculaRepository;
import com.institutoargentina.gestionestudiantes.dao.AlumnoRepository;
import com.institutoargentina.gestionestudiantes.dao.CursoRepository;

import com.institutoargentina.gestionestudiantes.modelo.Matricula;

import com.institutoargentina.gestionestudiantes.excepciones.AlumnoNoEncontradoException;
import com.institutoargentina.gestionestudiantes.excepciones.CursoNoEncontradoException;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlumnoRepository alumnoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(
            MatriculaRepository matriculaRepository,
            AlumnoRepository alumnoRepository,
            CursoRepository cursoRepository) {

        this.matriculaRepository = matriculaRepository;
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    // Listar todas las matrículas
    public List<Matricula> listar() {
        return matriculaRepository.findAll();
    }
    

    // Listar matrículas de un alumno
    public List<Matricula> listarPorAlumno(Integer idAlumno) {
        return matriculaRepository.findByIdAlumno(idAlumno);
    }


    // Buscar matrícula por ID
    public Matricula obtenerPorId(Integer id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() ->
                    new MatriculaNoEncontradaException(
                        "Matrícula no encontrada con ID: " + id
                    )
                );
    }
    // Validar que existan el alumno y el curso
    private void validarAlumnoYCurso(Matricula matricula) {

    	if (matricula.getIdAlumno() == null ||
    		!alumnoRepository.existsById(matricula.getIdAlumno())) {

    		throw new AlumnoNoEncontradoException(
    		     "Alumno no encontrado con ID: " + matricula.getIdAlumno()
    		 );
    		}

    	if (matricula.getIdCurso() == null ||
    		!cursoRepository.existsById(matricula.getIdCurso())) {

    		 throw new CursoNoEncontradoException(
    		      "Curso no encontrado con ID: " + matricula.getIdCurso()
    		    );
    		}
    }

    // Registrar matrícula
    @Transactional
    public Matricula registrar(Matricula matricula) {
        validarAlumnoYCurso(matricula);
        return matriculaRepository.save(matricula);
    }

    // Actualizar matrícula
    @Transactional
    public Matricula actualizar(Integer id, Matricula datos) {

        Matricula existente = obtenerPorId(id);

        validarAlumnoYCurso(datos);

        existente.setFechaMatricula(datos.getFechaMatricula());
        existente.setEstado(datos.getEstado());
        existente.setIdAlumno(datos.getIdAlumno());
        existente.setIdCurso(datos.getIdCurso());

        return matriculaRepository.save(existente);
    }

    // Eliminar matrícula
    @Transactional
    public void eliminar(Integer id) {
        Matricula existente = obtenerPorId(id);
        matriculaRepository.delete(existente);
    }
}
