package model;

import exception.AtributoVacioException;
import exception.MenorDeEdadException;

import java.time.LocalDate;
import java.util.UUID;

public class Piloto {
    private UUID licencia;
    private String nombre;
    private String documento;
    private LocalDate fecha_nacimiento;

    public  Piloto(UUID licencia, String nombre, String documento, LocalDate fecha_nacimiento) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public static Piloto create(UUID licencia, String nombre, String documento, LocalDate fecha_nacimiento){
        if (nombre.isEmpty() || documento.isEmpty()){
            throw new AtributoVacioException("Ningun atributo puede ser vacio");
        }
        if (fecha_nacimiento.plusYears(18).isAfter(LocalDate.now())){
            throw new MenorDeEdadException("El piloto no opude ser menor de edad");
        }
        return new Piloto(licencia, nombre, documento, fecha_nacimiento);
    }


    public UUID getLicencia() {
        return licencia;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
}
