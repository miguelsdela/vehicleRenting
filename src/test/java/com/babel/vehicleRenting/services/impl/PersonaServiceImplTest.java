package com.babel.vehicleRenting.services.impl;

import com.babel.vehicleRenting.exceptions.RequestApiValidationException;
import com.babel.vehicleRenting.models.Direccion;
import com.babel.vehicleRenting.models.Persona;
import com.babel.vehicleRenting.persistance.database.mappers.DireccionMapper;
import com.babel.vehicleRenting.persistance.database.mappers.PersonaMapper;
import com.babel.vehicleRenting.services.PersonaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;

//Los test con TDD (Primero haces los test y después vas programando)
public class PersonaServiceImplTest {
    PersonaService personaService;
    PersonaMapper personaMapper;
    DireccionMapper direccionMapper;

    @BeforeEach
    void setUpAll() {
        personaMapper = Mockito.mock(PersonaMapper.class);
        direccionMapper = Mockito.mock(DireccionMapper.class);
        personaService = new PersonaServiceImpl(personaMapper, direccionMapper);
    }

    @Test
    public void getPerson_should_throwApiValidationException_when_idNegative() {
        //Then
        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            int idPersona = -50;
            //When
            Persona persona = personaService.getPerson(idPersona);
        });
    }

    @Test
    public void getPerson_should_throwApiValidationException_when_idZero() {
        //Then
        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            int idPersona = 0;
            //When
            Persona persona = personaService.getPerson(idPersona);
        });
    }

    private static Persona createPersona() throws ParseException {
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido1("Francés");
        persona.setApellido2("Antúnes");
        persona.setFechaNacimiento(new SimpleDateFormat("dd-MM-yyyy").parse("29-12-1980"));

        Direccion direccion = new Direccion();
        direccion.setTipoViaId(1);
        direccion.setNombreCalle("Gran Vía");
        direccion.setNumero("120");
        direccion.setCodPostal("36201");
        direccion.setMunicipio("Pontevedra");
        direccion.setProvinciaCod("36");

        Direccion notifiacion = new Direccion();
        notifiacion.setTipoViaId(2);
        notifiacion.setNombreCalle("Puerta del Sol");
        notifiacion.setNumero("5");
        notifiacion.setCodPostal("28001");
        notifiacion.setMunicipio("Madrid");
        notifiacion.setProvinciaCod("28");

        persona.setDireccionNotificacion(direccion);
        persona.setDireccionDomicilioSameAsNotification(true);
        persona.setDireccionNotificacion(notifiacion);
        return persona;
    }

    @Test
    public void addPersona_should_throwApiValidationException_when_nombreIsNull() throws ParseException, RequestApiValidationException {
        //Then
        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            Persona persona = createPersona();
            persona.setNombre(null);
            //When
            this.personaService.addPersona(persona);
        });

    }

    @Test
    public void addPersona_should_throwApiValidationException_when_nombreIsEmpty() throws ParseException, RequestApiValidationException {
        //Then
        Assertions.assertThrows(RequestApiValidationException.class, () -> {
            //Given
            Persona persona = createPersona();
            persona.setNombre("");
            //When
            this.personaService.addPersona(persona);
        });
    }

    @Test
    public void addPersonaDireccion_should_bothAddressEquals_when_dirDomicilioSameAsNotification() throws ParseException, RequestApiValidationException {
        //Given
        Persona persona = createPersona();
        //When
        this.personaService.addPersona(persona);
        //then
        Assertions.assertEquals(persona.getDireccionDomicilio(), persona.getDireccionNotificacion());
    }

    @Test
    public void addPersonaDireccion_should_bothAddressDiferent_when_dirDomicilioSameAsNotification() throws ParseException, RequestApiValidationException {
        //Given
        Persona persona = createPersona();
        persona.setDireccionDomicilioSameAsNotification(false);
        //When
        this.personaService.addPersona(persona);
        //then
        Assertions.assertNotEquals(persona.getDireccionDomicilio(), persona.getDireccionNotificacion());
    }

    @Test
    public void addPersonaDireccion_should_callInsertDireccionDomicilio() throws ParseException, RequestApiValidationException {
        //TODO: Test no terminado, a la espera de que Roi nos resuelva la duda
        int idDireccion = 20;
        //when(direccionMapper.insertDireccion(any())).thenReturn(true);
        //Given
        Persona persona = createPersona();
        persona.setDireccionDomicilioSameAsNotification(false);
        //When
        this.personaService.addPersona(persona);
        //then
        Assertions.assertNotEquals(persona.getDireccionDomicilio(), persona.getDireccionNotificacion());
    }
}
