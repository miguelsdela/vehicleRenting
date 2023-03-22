package com.babel.vehicleRenting.services.impl;

import com.babel.vehicleRenting.models.RentaAnual;
import com.babel.vehicleRenting.persistance.database.mappers.RentaAnualMapper;
import com.babel.vehicleRenting.services.RentaAnualService;
import org.springframework.stereotype.Service;

@Service
public class RentaAnualServiceImpl implements RentaAnualService {

    private RentaAnualMapper rentaAnualMapper;

    public RentaAnualServiceImpl(RentaAnualMapper rentaAnualMapper) {
        this.rentaAnualMapper = rentaAnualMapper;
    }

    @Override
    public RentaAnual addRentaAnual(RentaAnual rentaAnual) {
        this.rentaAnualMapper.insertRentaAnual(rentaAnual);
        return rentaAnual;
    }

}
