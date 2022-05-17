package cl.methods;

import java.util.ArrayList;

public class BasicJava {
    public void numerosDel1Al255() {
        for (int i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }
    public void numerosImparesDel1Al255() {
        for (int i = 1; i < 256; i++) {
            if (i%2==1) {
                System.out.println(i);
            }
        }
    }
    public void sumaDel0Al255() {
        Integer suma = 0;
        for (int i = 0; i < 256; i++) {
             suma = suma + i;
             System.out.println("Nuevo numero: " + i + " Suma: " + suma);
        }
    }
    public void recorrerUnArreglo(Object[] X) {
        for (Object item : X) {
            System.out.println(item);
        }
    }
    public int maximo(int[] X) {
        int max = X[0];
        for (int i : X) {
            if (i>=max) {
                max = i;
            }
        }
        return max;
    }
    public double obtenerElPromedio(Double[] X) {
        Double suma = 0.0;
        for (int i = 0; i < X.length; i++) {
            suma = suma + X[i];
        }
        System.out.println(suma);
        return (double) suma/X.length;
    }
    public ArrayList<Integer> arregloConNumerosImpares() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            if (i%2 == 1) {
                y.add(i);
            }
        }
        return y;
    }
    public int mayorQueY(int[] lista, int y) {
        int contador = 0;
        for (int numero : lista) {
            if (numero > y) {
                contador++;
            }
        }
        return contador;
    }
    public void valoresAlCuadrado(int[] X) {
        for (int i = 0; i < X.length; i++) {
            X[i] = X[i]*X[i];
        }
    }
}
