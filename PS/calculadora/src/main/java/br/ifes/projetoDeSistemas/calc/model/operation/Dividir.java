package br.ifes.projetoDeSistemas.calc.model.operation;

public class Dividir implements IOperation{

    
    public int calc(int value1, int value2) {
        if (value2 == 0) throw new ArithmeticException("não é possivel dividir por 0");
        return value1/value2;
    }

}
