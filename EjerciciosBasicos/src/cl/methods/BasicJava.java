package cl.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class BasicJava {
    public void numerosDel1Al255() {
        for (Integer i = 1; i < 256; i++) {
            System.out.println(i);
        }
    }
    public void numerosImparesDel1Al255() {
        for (Integer i = 1; i < 256; i++) {
            if (i%2==1) {
                System.out.println(i);
            }
        }
    }
    public void sumaDel0Al255() {
        Integer suma = 0;
        for (Integer i = 0; i < 256; i++) {
             suma = suma + i;
             System.out.println("Nuevo numero: " + i + " Suma: " + suma);
        }
    }
    public void recorrerUnArreglo(Object[] X) {
        for (Object item : X) {
            System.out.println(item);
        }
    }
    public int maximo(ArrayList<Integer> X) {
        Integer max = X.get(0);
        for (Integer i : X) {
            if (i>=max) {
                max = i;
            }
        }
        return max;
    }
    public double obtenerElPromedio(ArrayList<Double> X) {
        Double suma = 0.0;
        for (Integer i = 0; i < X.size(); i++) {
            suma = suma + X.get(i);
        }
        System.out.println(suma);
        return (double) suma/X.size();
    }
    public ArrayList<Integer> arregloConNumerosImpares() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (Integer i = 0; i < 256; i++) {
            if (i%2 == 1) {
                y.add(i);
            }
        }
        return y;
    }
    public Integer mayorQueY(ArrayList<Integer> lista, int y) {
        Integer contador = 0;
        for (Integer numero : lista) {
            if (numero > y) {
                contador++;
            }
        }
        return contador;
    }
    public void valoresAlCuadrado(ArrayList<Integer> X) {
        for (int i = 0; i < X.size(); i++) {
            X.set(i, X.get(i)*X.get(i));
        }
    }
    public void eliminarNumerosNegativos(ArrayList<Integer> X) {
        ListIterator<Integer> itr = X.listIterator();
        while (itr.hasNext()) {
            if (itr.next() < 0) {
                itr.remove();
            }
        }
    }
    public ArrayList<Double> minMaxPromedio(ArrayList<Double> X) {
        Double max = X.get(0);
        Double min = X.get(0);
        Double sum = 0.0;
        for (int i = 0; i < X.size(); i++) {
            sum = sum + X.get(i);
            if (X.get(i) > max) {
                max = X.get(i);
            } else if (X.get(i) < min) {
                min = X.get(i);
            }
        }
        ArrayList<Double> min_max_promedio = new ArrayList<>();
        Collections.addAll(min_max_promedio, min, max, sum/X.size());
        return min_max_promedio;
    }
    public void cambiandoValoresArreglo(ArrayList<Integer> X) {
        Collections.rotate(X, -1);
        X.set(X.size() - 1, 0);
    }

}
