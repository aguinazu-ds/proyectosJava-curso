package classes;

public class Calculator {
    private Double operandOne = 0.0;
    private Double operandTwo = 0.0;
    private String operation = "";
    private Double resultado = 0.0;

    public Calculator(){};

    public Calculator(Double operandOne, String operation, Double operandTwo) {
        this.operandOne = operandOne;
        this.operandTwo = operandTwo;
        this.operation = operation;
    }

    public Double getOperandOne() {
        return this.operandOne;
    }

    public void setOperandOne(Double operandOne) {
        this.operandOne = operandOne;
    }

    public Double getOperandTwo() {
        return this.operandTwo;
    }

    public void setOperandTwo(Double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getResultado() {
        return this.resultado;
    }

    public void setResultado(Double result) {
        this.resultado = result;
    }

    public void performOperation() {
        if (this.getOperation() == "+") {
            this.setResultado(this.getOperandOne() + this.getOperandTwo());
        }
        if (this.getOperation() == "-") {
            this.setResultado(this.getOperandOne() - this.getOperandTwo());
        }
    }

    public void getResult() {
        System.out.println(this.getResultado());
    }
}
