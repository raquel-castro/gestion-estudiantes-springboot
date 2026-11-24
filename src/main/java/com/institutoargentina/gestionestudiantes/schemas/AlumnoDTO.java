
package com.institutoargentina.gestionestudiantes.schemas;

import com.institutoargentina.gestionestudiantes.modelo.Alumno;

public class AlumnoDTO {

    private Integer idAlumno;
    private Integer idPersona;
    private String dni;
    private String nombres;
    private String apellidos;
    private String estadoAcademico;
    private String carrera;
    private String cicloIngreso;
    private String turnoActual;
    private String condicionAlumno;

    // Convertir entidad Alumno a AlumnoDTO
    public static AlumnoDTO fromEntity(Alumno alumno) {

        AlumnoDTO dto = new AlumnoDTO();

        dto.idAlumno = alumno.getIdAlumno();

        if (alumno.getPersona() != null) {
            dto.idPersona = alumno.getPersona().getIdPersona();
            dto.dni = alumno.getPersona().getDni();
            dto.nombres = alumno.getPersona().getNombres();
            dto.apellidos = alumno.getPersona().getApellidos();
        }

        dto.estadoAcademico = alumno.getEstadoAcademico();
        dto.carrera = alumno.getCarrera();
        dto.cicloIngreso = alumno.getCicloIngreso();
        dto.turnoActual = alumno.getTurnoActual();
        dto.condicionAlumno = alumno.getCondicionAlumno();

        return dto;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCicloIngreso() {
        return cicloIngreso;
    }

    public String getTurnoActual() {
        return turnoActual;
    }

    public String getCondicionAlumno() {
        return condicionAlumno;
    }
}
