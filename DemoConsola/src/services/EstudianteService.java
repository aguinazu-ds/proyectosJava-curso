package services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import interfaces.IEstudiante;
import models.Estudiante;

public class EstudianteService implements IEstudiante {

    @Override
    public Integer calcular_edad(Estudiante estudiante) {
        LocalDate fechaHoy = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(estudiante.getFecha_nacimiento(), formatter);

        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }
}
