
package com.institutoargentina.gestionestudiantes.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Integer idAlumno;

    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @Column(name = "estado_academico")
    private String estadoAcademico;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "ciclo_ingreso")
    private String cicloIngreso;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fecha_termino")
    private LocalDate fechaTermino;

    @Column(name = "turno_actual")
    private String turnoActual;

    @Column(name = "condicion_alumno")
    private String condicionAlumno;

    public Alumno() {
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(String estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCicloIngreso() {
        return cicloIngreso;
    }

    public void setCicloIngreso(String cicloIngreso) {
        this.cicloIngreso = cicloIngreso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(String turnoActual) {
        this.turnoActual = turnoActual;
    }

    public String getCondicionAlumno() {
        return condicionAlumno;
    }

    public void setCondicionAlumno(String condicionAlumno) {
        this.condicionAlumno = condicionAlumno;
    }
}
