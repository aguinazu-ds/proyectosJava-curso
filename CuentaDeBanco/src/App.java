public class App {
    public static void main(String[] args) throws Exception {
        BankAccount cuentaPersonal = new BankAccount();

        cuentaPersonal.depositarDinero("Ahorro", 125000.0);
        cuentaPersonal.depositarDinero("Corriente", 42600.0);
        cuentaPersonal.Balance();
        cuentaPersonal.retirarDinero("Corriente", 43000.0);
        cuentaPersonal.retirarDinero("Corriente", 4000.0);
        cuentaPersonal.Balance();
    }
}
