package com.babel.vehicleRenting.services;

import com.babel.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.vehicleRenting.models.Persona;

public interface PersonaService {

    Persona addPersona(Persona persona) throws RequestApiValidationException;
}
