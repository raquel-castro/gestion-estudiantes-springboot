package com.institutoargentina.gestionestudiantes.excepciones;

public class AlumnoNoEncontradoException extends RuntimeException {

    public AlumnoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}