package br.ifes.projetoDeSistemas.calc.application;

import br.ifes.projetoDeSistemas.calc.controller.ControllerCalc;
import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;
import br.ifes.projetoDeSistemas.calc.dto.ResponseDTO;
import br.ifes.projetoDeSistemas.calc.view.Menu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Menu menu = new Menu();
        RequestDTO requestDTO = menu.show();
        ControllerCalc controllerCalc = new ControllerCalc();
        ResponseDTO responseDTO = controllerCalc.calc(requestDTO);
        menu.showResult(responseDTO);


    }
}
