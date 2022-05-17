// import java.util.ArrayList;
import java.util.Arrays;

import cl.methods.BasicJava;

public class App {
    public static void main(String[] args) throws Exception {
        BasicJava bJ = new BasicJava();

        //bJ.numerosDel1Al255(); // Imprimir numeros del 1 al 255
        //bJ.numerosImparesDel1Al255(); // Imprimir numeros impares del 1 al 255
        // bJ.sumaDel0Al255(); // suma de los primeros 255 numeros

        //Integer[] myArray = {1,2,3,4,56,678}; 
        // bJ.recorrerUnArreglo(myArray);

        // int[] test_max = {10,-1,12,-2,-3,0};
        // System.out.println(bJ.maximo(test_max));

        // Double[] test_promedio = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,1.5};
        // System.out.println("Promedio de: " + bJ.obtenerElPromedio(test_promedio));

        // ArrayList<Integer> y = bJ.arregloConNumerosImpares();
        // System.out.println(y);

        // int[] test_mayorqueY = {1,2,3,4,5,6,7,8,9};
        // System.out.println(bJ.mayorQueY(test_mayorqueY, 10));

        int[] test_valoresalcuadrado = {1,2,3,4};
        System.out.println(test_valoresalcuadrado);
        bJ.valoresAlCuadrado(test_valoresalcuadrado);
        System.out.println(Arrays.toString(test_valoresalcuadrado));

    }
}
