package com.babel.vehicleRenting.controllers;

import com.babel.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.vehicleRenting.models.Persona;
import com.babel.vehicleRenting.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/persona")
    ResponseEntity addPersona(@RequestBody Persona persona) {
        try {
            this.personaService.addPersona(persona);
        } catch (RequestApiValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comprueba los datos de entrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(String.format("Persona añadida. Id: %d", persona.getPersonaId()));
    }
}
