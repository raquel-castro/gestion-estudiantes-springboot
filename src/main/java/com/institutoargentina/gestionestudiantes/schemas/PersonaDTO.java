
package com.institutoargentina.gestionestudiantes.schemas;

import java.time.LocalDate;

import com.institutoargentina.gestionestudiantes.modelo.Persona;

public class PersonaDTO {

    private Integer idPersona;
    private String dni;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Integer idDistrito;

    public static PersonaDTO fromEntity(Persona persona) {

        PersonaDTO dto = new PersonaDTO();

        dto.idPersona = persona.getIdPersona();
        dto.dni = persona.getDni();
        dto.nombres = persona.getNombres();
        dto.apellidos = persona.getApellidos();
        dto.telefono = persona.getTelefono();
        dto.correo = persona.getCorreo();
        dto.direccion = persona.getDireccion();
        dto.fechaNacimiento = persona.getFechaNacimiento();
        dto.idDistrito = persona.getIdDistrito();

        return dto;
    }

    public Integer getIdPersona() { return idPersona; }
    public String getDni() { return dni; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public Integer getIdDistrito() { return idDistrito; }
}
