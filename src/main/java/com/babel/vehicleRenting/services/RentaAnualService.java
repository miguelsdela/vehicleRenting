package com.babel.vehicleRenting.services;

import com.babel.vehicleRenting.exceptions.PersonaNotFoundException;
import com.babel.vehicleRenting.exceptions.ProfesionNotFoundException;
import com.babel.vehicleRenting.models.RentaAnual;

public interface RentaAnualService {

    RentaAnual addRentaAnual(RentaAnual rentaAnual) throws PersonaNotFoundException, ProfesionNotFoundException;
}
