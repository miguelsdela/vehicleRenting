package com.babel.vehicleRenting.persistance.database.mappers;

import com.babel.vehicleRenting.models.RentaAnual;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface ProfesionMapper {

    @Insert("INSERT INTO PROFESION (DESCRIPCION) VALUES (#{descripcion}))")
    @Options(useGeneratedKeys = true, keyProperty = "profesionId", keyColumn = "PROFESION_ID")
    void insertProfesion(RentaAnual rentaAnual);
}
