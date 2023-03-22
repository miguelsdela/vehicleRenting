package com.babel.vehicleRenting.controllers;

import com.babel.vehicleRenting.services.RentaAnualService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentaAnualController {
    RentaAnualService rentaAnualService;

    public RentaAnualController(RentaAnualService rentaAnualService) {
        this.rentaAnualService = rentaAnualService;
    }

    @PostMapping("/renta")
    ResponseEntity addRentaAnual() {
        return ResponseEntity.ok("Funciona el controlador.");
    }
}
