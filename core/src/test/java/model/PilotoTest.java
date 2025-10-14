package model;

import exception.MenorDeEdadException;
import input.CrearPilotoInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import output.RepositorioPiloto;
import usecase.CrearPilotoUseCase;

import java.time.LocalDate;
import java.util.UUID;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PilotoTest {
    @Mock
    RepositorioPiloto repositorioPilotoMock;
    private final String nombre = "Franco Colapinto";
    private final String documento = "123456ABC";
    private final LocalDate fechaNacimiento = LocalDate.of(1999, 1, 1);
    @Test
    public void PilotoTest(){

        when(repositorioPilotoMock.existeDocumento(documento)).thenReturn(false);
        when(repositorioPilotoMock.guardarPiloto(any(Piloto.class))).thenAnswer(i -> i.getArgument(0));

        CrearPilotoInput crearPilotoInput = new CrearPilotoUseCase(repositorioPilotoMock);

        UUID resLicencia = crearPilotoInput.crearPiloto(nombre, documento, fechaNacimiento);

        Assertions.assertNotNull(resLicencia);
    }

    //private final LocalDate fechaNacimiento = LocalDate.of(2020, 1, 1);
   /* @Test
    public void PilotoTest_MenorDeEdad(){
        when(repositorioPilotoMock.existeDocumento(documento)).thenReturn(false);
        when(repositorioPilotoMock.guardarPiloto(any(Piloto.class))).thenAnswer(i -> i.getArgument(0));

        CrearPilotoInput crearPilotoInput = new CrearPilotoUseCase(repositorioPilotoMock);

        UUID resLicencia = crearPilotoInput.crearPiloto(nombre, documento, fechaNacimiento);

        Assertions.assertThrows(MenorDeEdadException.class, ()->{crearPilotoInput.crearPiloto(nombre, documento, fechaNacimiento);});
    }*/
}
