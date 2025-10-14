package input;

import java.time.LocalDate;
import java.util.UUID;

public interface CrearPilotoInput {
    UUID crearPiloto(String nombre, String documento, LocalDate fechaNacimiento);
}
