import java.util.Scanner;

import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
        Estudiante estudiante = new Estudiante();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrechar fecha de nacimeinto del estudiante (ej. 07/04/1985):");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("La edad del estudiante es " + estudiante.calcular_edad(fechaNacimiento));

    }
}
