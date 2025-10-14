package ar.edu.undec.adapter.piloto.modelo;

import java.time.LocalDate;
import java.util.Locale;

public class Piloto {
    private String licencia;
    private String nombre;
    private String documento;
    private LocalDate fecha_nacimiento;

    public  Piloto(String licencia, String nombre, String documento, LocalDate fecha_nacimiento) {
        this.licencia = licencia;
        this.nombre = nombre;
        this.documento = documento;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public create(String licencia,){

    }


    public String getLicencia() {
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
