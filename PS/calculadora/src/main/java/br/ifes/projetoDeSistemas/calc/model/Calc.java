package br.ifes.projetoDeSistemas.calc.model;

import br.ifes.projetoDeSistemas.calc.model.operation.IOperation;

public class Calc implements ICalc{

    @Override
    public int calculation(IOperation operation, int value1, int value2) {
        return operation.calc(value1,value2);
    }

}
