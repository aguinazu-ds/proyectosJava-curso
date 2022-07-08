import java.util.Random;

public class BankAccount {
    private String numeroCuenta;
    private Double saldoCuentaCorriente = 0.0;
    private Double saldoCuentaAhorro = 0.0;
    private static int numeroCuentasCreadas = 0;
    private static Double totalDineroAcumulado = 0.0;

    public BankAccount() {
        String numeroCuenta = getRandomNumber();
        Double saldoCuentaCorriente = 0.0;
        Double saldoCuentaAhorro = 0.0;
        numeroCuentasCreadas += 1;
        System.out.println("Nueva Cuenta Bancaria Creada " + numeroCuenta );
    }

    //Getter y Setters
    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public Double getSaldoCuentaCorriente() {
        return this.saldoCuentaCorriente;
    }

    private void setSaldoCuentaCorriente(Double saldoCuentaCorriente) {
        this.saldoCuentaCorriente = saldoCuentaCorriente;
    }

    public Double getSaldoCuentaAhorro() {
        return this.saldoCuentaAhorro;
    }

    private void setSaldoCuentaAhorro(Double saldoCuentaAhorro) {
        this.saldoCuentaAhorro = saldoCuentaAhorro;
    }

    public void depositarDinero(String tipoCuenta, Double cantidadDinero) {
        if (tipoCuenta == "Corriente") {
            setSaldoCuentaCorriente(getSaldoCuentaCorriente() + cantidadDinero);
            totalDineroAcumulado += cantidadDinero;
        } else if (tipoCuenta == "Ahorro") {
            setSaldoCuentaAhorro(getSaldoCuentaAhorro() + cantidadDinero);
            totalDineroAcumulado += cantidadDinero;
        } else {
            System.out.println("Tipo de Cuenta Bancaria incorrecta, por favor elige entre Corriente o Ahorro");
        }        
    }

    public void retirarDinero(String tipoCuenta, Double cantidadDinero) {
        if (tipoCuenta == "Corriente") {
            if (cantidadDinero <= getSaldoCuentaCorriente()) {
                setSaldoCuentaCorriente(getSaldoCuentaCorriente() - cantidadDinero);
                totalDineroAcumulado -= cantidadDinero;
            } else {
                System.out.println("Saldo insuficiente en tu cuenta Corriente");
            }
        } else if (tipoCuenta == "Ahorro") {
            if (cantidadDinero <= getSaldoCuentaAhorro()) {
                setSaldoCuentaAhorro(getSaldoCuentaAhorro() - cantidadDinero);
                totalDineroAcumulado -= cantidadDinero;
            } else {
                System.out.println("Saldo insuficiente en tu Cuenta de Ahorros");
            }
        } else {
            System.out.println("El tipo de cuenta ingresado es incorrecto, por favor elige entre Corriente o Ahorro");
        }
    }

    public void Balance() {
        System.out.println("El saldo de tu cuenta Corriente es: $" + getSaldoCuentaCorriente());
        System.out.println("El saldo de tu cuenta de Ahorros es: $" + getSaldoCuentaAhorro());
    }

    private String getRandomNumber() {
        String numeros = "0123456789";
        String numeroAleatorio = "";

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            char numero = numeros.charAt(rand.nextInt(10));
            numeroAleatorio += numero;
        }
        return numeroAleatorio;
    }

    

}
