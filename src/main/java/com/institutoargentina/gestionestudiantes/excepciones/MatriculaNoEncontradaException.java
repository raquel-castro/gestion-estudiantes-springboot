package com.institutoargentina.gestionestudiantes.excepciones;

public class MatriculaNoEncontradaException extends RuntimeException {

    public MatriculaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}