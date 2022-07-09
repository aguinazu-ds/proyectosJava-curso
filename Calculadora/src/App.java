import classes.Calculator;

public class App {
    public static void main(String[] args) throws Exception {
        Calculator test1 = new Calculator(10.5,"+",5.2);
        test1.performOperation();
        test1.getResult();
    }
}
