import java.util.ArrayList;

import methods.PuzzleJava;

public class App {
    public static void main(String[] args) throws Exception {
        PuzzleJava pJ = new PuzzleJava();

        // ArrayList<Integer> test_lista = pJ.mayoresADiez();
        // System.out.println(test_lista);

        // ArrayList<String> test_lista_nombres = pJ.arregloStrings();
        // System.out.println(test_lista_nombres);

        // pJ.abcedario();

        // ArrayList<Integer> lista_enteros_aleatorio = new ArrayList<>();
        // lista_enteros_aleatorio = pJ.arregloAleatorio();
        // System.out.println(lista_enteros_aleatorio);

        // ArrayList<Integer> lista_ordenada_enteros_aleatorio = new ArrayList<>();
        // lista_ordenada_enteros_aleatorio = pJ.arregloAleatorioOrdenados();
        // System.out.println(lista_ordenada_enteros_aleatorio);

        // String cadena_aleatoria = pJ.cadenaAleatoria();
        // System.out.println(cadena_aleatoria);

        ArrayList<String> lista_cadenas_aleatorias = new ArrayList<>();
        lista_cadenas_aleatorias = pJ.arregloCadenasAleatorias();
        System.out.println(lista_cadenas_aleatorias);
    }
}
