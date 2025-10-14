package ar.edu.undec.adapter.piloto.excepciones;

public class DniYaExisteException extends RuntimeException {
    public DniYaExisteException(String message) {
        super(message);
    }
}
