import java.util.Scanner;

import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        Estudiante estudiante = new Estudiante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar fecha de nacimiento del estudiante (ej. 07/04/1985):");
        String fechaNacimiento = scanner.nextLine();
        estudiante.setFecha_nacimiento(fechaNacimiento);
        System.out.println("La edad del Estudiante es " + estudiante.calcular_edad());
    }
}
