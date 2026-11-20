package com.institutoargentina.gestionestudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institutoargentina.gestionestudiantes.modelo.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}