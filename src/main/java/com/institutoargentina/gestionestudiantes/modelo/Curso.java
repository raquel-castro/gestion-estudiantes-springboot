
package com.institutoargentina.gestionestudiantes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @Column(name = "id_curso")
    private Integer idCurso;

    public Curso() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
