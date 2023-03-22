package com.babel.vehicleRenting.controllers;

import com.babel.vehicleRenting.exceptions.PersonaNotFoundException;
import com.babel.vehicleRenting.exceptions.ProfesionNotFoundException;
import com.babel.vehicleRenting.models.RentaAnual;
import com.babel.vehicleRenting.services.RentaAnualService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentaAnualController {
    RentaAnualService rentaAnualService;

    public RentaAnualController(RentaAnualService rentaAnualService) {
        this.rentaAnualService = rentaAnualService;
    }

    @PostMapping("/renta")
    ResponseEntity addRentaAnual(@RequestBody RentaAnual rentaAnual) {
        try {
            this.rentaAnualService.addRentaAnual(rentaAnual);
        } catch (ProfesionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, la profesion no existe.");
        } catch (PersonaNotFoundException p) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error, la persona no existe");
        }
        return ResponseEntity.ok(String.format("Renta anual añadida. Id: %d.", rentaAnual.getRentaId()));
    }
}
