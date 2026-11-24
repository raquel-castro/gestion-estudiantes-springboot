package com.institutoargentina.gestionestudiantes.excepciones;

public class CursoNoEncontradoException extends RuntimeException {

    public CursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}