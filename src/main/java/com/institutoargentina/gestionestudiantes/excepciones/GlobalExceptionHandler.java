package com.institutoargentina.gestionestudiantes.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Alumno no encontrado: 404
    @ExceptionHandler(AlumnoNoEncontradoException.class)
    public ResponseEntity<String> manejarAlumnoNoEncontrado(
            AlumnoNoEncontradoException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    // Curso no encontrado: 404
    @ExceptionHandler(CursoNoEncontradoException.class)
    public ResponseEntity<String> manejarCursoNoEncontrado(
            CursoNoEncontradoException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    // Matrícula no encontrada: 404
    @ExceptionHandler(MatriculaNoEncontradaException.class)
    public ResponseEntity<String> manejarMatriculaNoEncontrada(
            MatriculaNoEncontradaException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

    // Otros errores: 400
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarErrorGenerico(
            RuntimeException ex) {

        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}