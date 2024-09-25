package br.ifes.projetoDeSistemas.calc.model;

import br.ifes.projetoDeSistemas.calc.model.operation.IOperation;

public interface ICalc {
    public int calculation(IOperation operation, int value1, int value2);
}
