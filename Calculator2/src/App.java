import classes.Calculator;

public class App {
    public static void main(String[] args) throws Exception {
        Calculator calc1 = new Calculator();
        calc1.performOperation(10.5);
        calc1.performOperation("+");
        calc1.performOperation(5.2);
        calc1.performOperation("*");
        calc1.performOperation(10);
        calc1.performOperation("=");
        calc1.getResults();
    }
}
