
package com.institutoargentina.gestionestudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.institutoargentina.gestionestudiantes.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
