// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;

import cl.methods.BasicJava;

public class App {
    public static void main(String[] args) throws Exception {
        BasicJava bJ = new BasicJava();

        // bJ.numerosDel1Al255(); // Imprimir numeros del 1 al 255
        // bJ.numerosImparesDel1Al255(); // Imprimir numeros impares del 1 al 255
        // bJ.sumaDel0Al255(); // suma de los primeros 255 numeros

        // Integer[] myArray = {1,2,3,4,56,678}; 
        // bJ.recorrerUnArreglo(myArray);

        // ArrayList<Integer> test_max = new ArrayList<>();
        // Collections.addAll(test_max, 10,-1,12,-2,-3,0);
        // System.out.println(test_max);
        // System.out.println(bJ.maximo(test_max));       

        // ArrayList<Double> test_promedio = new ArrayList<>();
        // Collections.addAll(test_promedio, 1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,1.5);
        // System.out.println("Promedio de: " + bJ.obtenerElPromedio(test_promedio));

        // ArrayList<Integer> y = bJ.arregloConNumerosImpares();
        // System.out.println(y);

        // ArrayList<Integer> test_mayorqueY = new ArrayList<>();
        // Collections.addAll(test_mayorqueY, 1,2,3,4,5,6,7,8,9,10,11,12);
        // System.out.println(bJ.mayorQueY(test_mayorqueY, 4));

        // ArrayList<Integer> test_valoresAlCuadrado = new ArrayList<>();
        // Collections.addAll(test_valoresAlCuadrado, 1,2,3,4);
        // bJ.valoresAlCuadrado(test_valoresAlCuadrado);
        // System.out.println(test_valoresAlCuadrado);
        
        // ArrayList<Integer> test_eliminarNegativos = new ArrayList<>();
        // Collections.addAll(test_eliminarNegativos, 1,2,3,4,-1,-2,4,-5,-2,-2,1,1,-1,-1,0,-3,4,-1);
        // System.out.println(test_eliminarNegativos);
        // bJ.eliminarNumerosNegativos(test_eliminarNegativos);
        // System.out.println(test_eliminarNegativos);

        // ArrayList<Double> test_minMaxPromedio = new ArrayList<>();
        // Collections.addAll(test_minMaxPromedio, 1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0);
        // System.out.println(bJ.minMaxPromedio(test_minMaxPromedio).toString());

        ArrayList<Integer> test_cambiandoValores = new ArrayList<>();
        Collections.addAll(test_cambiandoValores, 1,2,3,4,5,5,6,7,8,9,0);
        bJ.cambiandoValoresArreglo(test_cambiandoValores);
        System.out.println(test_cambiandoValores);
    }
}
