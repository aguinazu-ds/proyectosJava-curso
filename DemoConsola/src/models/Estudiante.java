package models;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Estudiante {
    private int id_estudiante;
    private String rut;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direccion;
    private String fecha_nacimiento;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String rut, String nombre, String apellido_pat, String apellido_mat,
            String direccion, String fecha_nacimiento) {
        this.id_estudiante = id_estudiante;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer calcular_edad(String fechaNacimientoString) {
        LocalDate fechaHoy = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.now(ZoneId.systemDefault());
        try {
            fechaNacimiento = LocalDate.parse(fechaNacimientoString, formatter);
        } catch (Exception e) {
            System.out.println("Ingresa el formato correcto de fecha dd/MM/yyyy (ej. 02/07/1990)");
            System.out.println(e);
            return null;
        }
        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }

    public int getId_estudiante() {
        return this.id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return this.apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return this.apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return this.fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
