package com.institutoargentina.gestionestudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institutoargentina.gestionestudiantes.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}