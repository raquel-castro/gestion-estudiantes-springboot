package com.institutoargentina.gestionestudiantes.servicio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.institutoargentina.gestionestudiantes.dao.PersonaRepository;
import com.institutoargentina.gestionestudiantes.modelo.Persona;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    public Persona obtenerPorId(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Persona no encontrada con id " + id));
    }

    @Transactional
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }

    @Transactional
    public Persona actualizar(Integer id, Persona datos) {
        Persona existente = obtenerPorId(id);

        existente.setDni(datos.getDni());
        existente.setNombres(datos.getNombres());
        existente.setApellidos(datos.getApellidos());
        existente.setTelefono(datos.getTelefono());
        existente.setCorreo(datos.getCorreo());
        existente.setDireccion(datos.getDireccion());
        existente.setFechaNacimiento(datos.getFechaNacimiento());
        existente.setIdDistrito(datos.getIdDistrito());

        return personaRepository.save(existente);
    }

    @Transactional
    public void eliminar(Integer id) {
        Persona existente = obtenerPorId(id);
        personaRepository.delete(existente);
    }
}