package usecase;

import exception.DniYaExisteException;
import input.CrearPilotoInput;
import model.Piloto;
import output.RepositorioPiloto;

import java.time.LocalDate;
import java.util.UUID;

public class CrearPilotoUseCase implements CrearPilotoInput {
    public RepositorioPiloto repositorioPiloto;

    public CrearPilotoUseCase (RepositorioPiloto repositorioPiloto) {
         this.repositorioPiloto = repositorioPiloto;
    }

    @Override
    public UUID crearPiloto( String nombre, String documento, LocalDate fechaNacimiento) {
        if(repositorioPiloto.existeDocumento(documento)){
            throw new DniYaExisteException("Documento ya existe");
        }
        UUID licenciaNueva = UUID.randomUUID();

        Piloto piloto = Piloto.create(licenciaNueva, nombre, documento, fechaNacimiento);

        Piloto pilotoGuardado = repositorioPiloto.guardarPiloto(piloto);

        return pilotoGuardado.getLicencia();
    }
}
