package com.babel.vehicleRenting.services.impl;

import com.babel.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.vehicleRenting.exceptions.RequiredMissingFieldException;
import com.babel.vehicleRenting.exceptions.WorngLengthFieldException;
import com.babel.vehicleRenting.models.Persona;
import com.babel.vehicleRenting.persistance.database.mappers.DireccionMapper;
import com.babel.vehicleRenting.persistance.database.mappers.PersonaMapper;
import com.babel.vehicleRenting.services.PersonaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private DireccionMapper direccionMapper;
    private PersonaMapper personaMapper;

    public PersonaServiceImpl(PersonaMapper personaMapper, DireccionMapper direccionMapper) {
        this.personaMapper = personaMapper;
        this.direccionMapper = direccionMapper;

    }

    @Override
    @Transactional
    public Persona addPersona(Persona persona) throws RequestApiValidationException {
        this.validatePersonaData(persona);
        persona = this.addPersonaDireccion(persona);
        this.personaMapper.insertPersona(persona);
        return persona;
    }

    private Persona addPersonaDireccion(Persona persona) {
        this.direccionMapper.insertDireccion(persona.getDireccionDomicilio());
        if (persona.isDireccionDomicilioSameAsNotification()) {
            persona.setDireccionNotificacion(persona.getDireccionDomicilio());
        } else {
            this.direccionMapper.insertDireccion(persona.getDireccionNotificacion());
        }
        return persona;
    }

    private void validatePersonaData(Persona persona) throws RequestApiValidationException {
        this.validateNombre(persona);
    }

    private void validateNombre(Persona persona) throws RequestApiValidationException {
        if (persona.getNombre() == null || persona.getNombre().isEmpty()) {
            throw new RequiredMissingFieldException();
        }
        if (persona.getNombre().length() > 50) {
            throw new WorngLengthFieldException();
        }
    }
}
