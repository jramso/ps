package br.ifes.projetoDeSistemas.calc.controller;

import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;
import br.ifes.projetoDeSistemas.calc.dto.ResponseDTO;
import br.ifes.projetoDeSistemas.calc.model.Calc;
import br.ifes.projetoDeSistemas.calc.model.CalcX;
import br.ifes.projetoDeSistemas.calc.model.ICalc;
import br.ifes.projetoDeSistemas.calc.model.operation.Dividir;
import br.ifes.projetoDeSistemas.calc.model.operation.IOperation;
import br.ifes.projetoDeSistemas.calc.model.operation.Multiplicar;
import br.ifes.projetoDeSistemas.calc.model.operation.Somar;
import br.ifes.projetoDeSistemas.calc.model.operation.Subtrair;

public class ControllerCalc {

    public ResponseDTO calc(RequestDTO requestDTO){
        int result = 0;
        ICalc calc = null;
        if (requestDTO.getOpcao() == 1){
            calc = new Calc();

        }else {
            calc = new CalcX();
        }


        IOperation operation = null;
        switch (requestDTO.getOpcao()) {
            case 1:
                operation = new Somar();
                break;
            case 2:
                operation = new Subtrair();
                break;
            case 3:
                operation = new Multiplicar();
                break;
            case 4:
                operation = new Dividir();
                break;
        }
        result = calc.calculation(operation,requestDTO.getValor1(),requestDTO.getValor2());
        return new ResponseDTO(result);

    }

}
