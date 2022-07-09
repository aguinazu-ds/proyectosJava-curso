package classes;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<String> operaciones = new ArrayList<String>();
    private ArrayList<Double> numeros = new ArrayList<Double>();
    public Double results = 0.0;

    public Calculator() {
    }

    public void performOperation(Double num) {
        numeros.add(num);
    }

    public void performOperation(Integer num) {
        numeros.add(num.doubleValue());
    }

    public void performOperation(String operacion) {
        if (operacion != "=" && operacion != "+" && operacion != "-" && operacion != "/" && operacion != "*") {
            System.out.println("La operacion ingresada no es correcta (+ , - , / , * , =)");
            throw new RuntimeException("La operacion ingresada no es correcta (+ , - , / , * , =)");
        }
        if (operacion != "=") {
            this.operaciones.add(operacion);
        } else {
            this.results = this.numeros.get(0);
            for (int i = 0; i < operaciones.size(); i++) {
                if (operaciones.get(i) == "+") {
                    this.results = this.results + this.numeros.get(i+1);
                } else if (operaciones.get(i) == "-") {
                    this.results = this.results - this.numeros.get(i+1);
                } else if (operaciones.get(i) == "/") {
                    this.results = this.results / this.numeros.get(i+1);
                } else if (operaciones.get(i) == "*") {
                    this.results = this.results * this.numeros.get(i+1);
                }
            }            
        }
    }

    public void getResults() {
        System.out.println(this.results);
    }
}
