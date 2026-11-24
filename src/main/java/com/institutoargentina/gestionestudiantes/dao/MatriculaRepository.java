
package com.institutoargentina.gestionestudiantes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institutoargentina.gestionestudiantes.modelo.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

    // Buscar matrículas por ID del alumno
    List<Matricula> findByIdAlumno(Integer idAlumno);

}
