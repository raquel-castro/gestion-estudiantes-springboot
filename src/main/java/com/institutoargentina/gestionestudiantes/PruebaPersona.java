
package com.institutoargentina.gestionestudiantes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.institutoargentina.gestionestudiantes.dao.PersonaRepository;

@Component
public class PruebaPersona implements CommandLineRunner {

    private final PersonaRepository personaRepository;

    public PruebaPersona(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long total = personaRepository.count();

        System.out.println("TOTAL DE PERSONAS: " + total);
    }
}
