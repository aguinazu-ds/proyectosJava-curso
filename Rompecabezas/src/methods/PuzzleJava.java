package methods;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    public ArrayList<Integer> mayoresADiez() {
        ArrayList<Integer> lista = new ArrayList<>();
        Collections.addAll(lista, 3,5,1,2,7,9,8,13,25,32);
        ArrayList<Integer> listaMayorQueDiez = new ArrayList<>();
        Integer suma = 0;
        for (Integer integer : lista) {
            suma = suma + integer;
            if (integer>10) {
                listaMayorQueDiez.add(integer);
            }
        }
        System.out.println(suma);
        return listaMayorQueDiez;
    }
    public ArrayList<String> arregloStrings() {
        ArrayList<String> lista = new ArrayList<>();
        Collections.addAll(lista, "Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        ArrayList<String> listaStringLargos = new ArrayList<>();
        Collections.shuffle(lista);
        for (String nombre : lista) {
            System.out.println(nombre);
            if (nombre.length()>5) {
                listaStringLargos.add(nombre);
            }
        }
        return listaStringLargos;
    }
    public void abcedario() {
        ArrayList<String> abc = new ArrayList<>();
        Collections.addAll(abc, "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        ArrayList<String> vocales = new ArrayList<>();
        Collections.addAll(vocales, "a","e","i","o","u");
        Collections.shuffle(abc);
        System.out.println(abc.get(abc.size()-1));
        System.out.println(abc.get(0));
        if (vocales.contains(abc.get(0))) {
            System.out.println("La primera letra es una vocal.");
        }
    }
    public ArrayList<Integer> arregloAleatorio() {
        Random rand = new Random();
        ArrayList<Integer> lista_Enteros = new ArrayList<>(); 
        for (int i = 0; i < 10; i++) {
            int entero_aleatorio = rand.nextInt(45) + 55;
            lista_Enteros.add(entero_aleatorio);
        }
        return lista_Enteros;
    }
    public ArrayList<Integer> arregloAleatorioOrdenados() {
        Random rand = new Random();
        ArrayList<Integer> lista_Enteros = new ArrayList<>(); 
        for (int i = 0; i < 10; i++) {
            int entero_aleatorio = rand.nextInt(45) + 55;
            lista_Enteros.add(entero_aleatorio);
        }
        Collections.sort(lista_Enteros);
        System.out.println(lista_Enteros.get(0));
        System.out.println(lista_Enteros.get(lista_Enteros.size() - 1));
        return lista_Enteros;
    }
    public String cadenaAleatoria() {
        ArrayList<String> letras = new ArrayList<>();
        Collections.addAll(letras, "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        Random rand = new Random();
        String cadena = "";
        for (int i = 0; i < 5; i++) {
            int entero_aleatorio = rand.nextInt(25);
            cadena = cadena + letras.get(entero_aleatorio);
        }
        return cadena;
    }
    public ArrayList<String> arregloCadenasAleatorias() {
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(cadenaAleatoria());
        }
        return lista;
    }
}