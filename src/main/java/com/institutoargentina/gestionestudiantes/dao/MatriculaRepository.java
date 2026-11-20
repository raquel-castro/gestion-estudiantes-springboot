
package com.institutoargentina.gestionestudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.institutoargentina.gestionestudiantes.modelo.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

}
