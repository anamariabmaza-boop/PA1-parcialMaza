package output;

import model.Piloto;

import java.util.UUID;

public interface RepositorioPiloto {
    Piloto guardarPiloto(Piloto piloto);
    boolean existeDocumento(String documento);
}
