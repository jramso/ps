package br.ifes.projetoDeSistemas.calc.model;

import br.ifes.projetoDeSistemas.calc.model.operation.IOperation;

public class CalcX implements ICalc{

    @Override
    public int calculation(IOperation operation, int value1, int value2) {
        System.out.println("XXXXXX class");
        return operation.calc(value1, value2);
    }
    
}
