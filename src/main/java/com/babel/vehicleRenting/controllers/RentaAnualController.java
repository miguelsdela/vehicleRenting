package com.babel.vehicleRenting.controllers;

import com.babel.vehicleRenting.models.RentaAnual;
import com.babel.vehicleRenting.services.RentaAnualService;
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
        this.rentaAnualService.addRentaAnual(rentaAnual);
        return ResponseEntity.ok(String.format("Renta anual añadida. Id: %d.", rentaAnual.getRentaId()));
    }
}
