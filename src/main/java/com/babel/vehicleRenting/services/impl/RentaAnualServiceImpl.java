package com.babel.vehicleRenting.services.impl;

import com.babel.vehicleRenting.exceptions.PersonaNotFoundException;
import com.babel.vehicleRenting.exceptions.ProfesionNotFoundException;
import com.babel.vehicleRenting.models.RentaAnual;
import com.babel.vehicleRenting.persistance.database.mappers.PersonaMapper;
import com.babel.vehicleRenting.persistance.database.mappers.ProfesionMapper;
import com.babel.vehicleRenting.persistance.database.mappers.RentaAnualMapper;
import com.babel.vehicleRenting.services.RentaAnualService;
import org.springframework.stereotype.Service;

@Service
public class RentaAnualServiceImpl implements RentaAnualService {

    private RentaAnualMapper rentaAnualMapper;
    private ProfesionMapper profesionMapper;
    private PersonaMapper personaMapper;

    public RentaAnualServiceImpl(RentaAnualMapper rentaAnualMapper, ProfesionMapper profesionMapper, PersonaMapper personaMapper) {
        this.rentaAnualMapper = rentaAnualMapper;
        this.profesionMapper = profesionMapper;
        this.personaMapper = personaMapper;
    }

    @Override
    public RentaAnual addRentaAnual(RentaAnual rentaAnual) throws PersonaNotFoundException, ProfesionNotFoundException {
        this.validateProfesion(rentaAnual.getProfesion().getProfesionId());
        this.validatePersona(rentaAnual.getPersona().getPersonaId());
        this.rentaAnualMapper.insertRentaAnual(rentaAnual);
        return rentaAnual;
    }

    private void validateProfesion(int profesionId) throws ProfesionNotFoundException {
        if (profesionMapper.existeProfesion(profesionId) == 0) {
            throw new ProfesionNotFoundException();
        }
    }

    private void validatePersona(int personaId) throws PersonaNotFoundException {
        if (personaMapper.existePersona(personaId) == 0) {
            throw new PersonaNotFoundException();
        }
    }
}
