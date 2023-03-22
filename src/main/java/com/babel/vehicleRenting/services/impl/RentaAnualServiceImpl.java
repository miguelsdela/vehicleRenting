package com.babel.vehicleRenting.services.impl;

import com.babel.vehicleRenting.models.RentaAnual;
import com.babel.vehicleRenting.services.RentaAnualService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentaAnualServiceImpl implements RentaAnualService {
    @Override
    @Transactional
    public RentaAnual addRentaAnual(RentaAnual rentaAnual) {
        return null;
    }

    private RentaAnual addRentaAnualProfesion(RentaAnual rentaAnual) {
        return null;
    }
}
