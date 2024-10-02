package br.ifes.projetoDeSistemas.calc.application;

import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;
import br.ifes.projetoDeSistemas.calc.dto.ResponseDTO;


public class App 
{
    public static void main(String[] args) {
        try {
            // Instanciar dinamicamente a classe Menu
            Class<?> menu = Class.forName("br.ifes.projetoDeSistemas.calc.view.Menu");
            Object menuInstance = menu.getDeclaredConstructor().newInstance();

            // Chamar o método 'show' dinamicamente
            RequestDTO requestDTO =(RequestDTO) menu.getMethod("show").invoke(menuInstance);

            // Processar a operação no controller
                // Instanciar dinamicamente a classe ControllerCalc
            Class<?> controllerClass = Class.forName("br.ifes.projetoDeSistemas.calc.controller.ControllerCalc");
            Object controllerInstance = controllerClass.getDeclaredConstructor().newInstance();

            // Chamar o método 'calc' do ControllerCalc dinamicamente para obter ResponseDTO
            ResponseDTO responseDTO = (ResponseDTO) controllerClass.getMethod("calc", RequestDTO.class).invoke(controllerInstance, requestDTO);

            // Chamar outro método dinamicamente
            // Aqui usamos o Reflection e não precisamos importar Menu diretamente
            menu.getMethod("showResult", ResponseDTO.class).invoke(menuInstance, responseDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
