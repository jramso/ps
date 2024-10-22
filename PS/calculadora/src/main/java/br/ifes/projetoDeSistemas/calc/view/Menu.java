package br.ifes.projetoDeSistemas.calc.view;

import java.util.Scanner;
import java.util.Set;

import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;
import br.ifes.projetoDeSistemas.calc.dto.ResponseDTO;
import br.ifes.projetoDeSistemas.calc.model.operation.IOperation;
import org.reflections.Reflections;

public class Menu {

    public RequestDTO showDTO(){
        this.showMenu();
        return this.captureValues();
    }

    public void showMenu(){
        System.out.println("Olá bem vindo a NaoSeiCalcularDeCabeca");
        System.out.println("Escolha uma das opções");
        System.out.println("1 - Somar");
        System.out.println("2 - Subtrair");
        System.out.println("3 - Multiplicar");
        System.out.println("4 - Dividir");
        System.out.println("5 - Sair do Programa");
    }

    private RequestDTO captureValues(){
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        if (opcao == 5) {
            System.exit(0);
        }
        System.out.println("Informe o primeiro valor:");
        int valor1 = entrada.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = entrada.nextInt();

        return new RequestDTO(opcao,valor1,valor2);
    }

    public void showResult (ResponseDTO responseDTO){
        System.out.println("O Resultado é: "+responseDTO.getResult());
        System.out.print("\n");
        showCalc();
    }

    public static void show(){
        Reflections reflections = new Reflections("br.ifes.projetoDeSistemas.calc");

        // Busca todas as classes que implementam a interface IOperation
        Set<Class<? extends IOperation>> classes = reflections.getSubTypesOf(IOperation.class);

        // Imprime o nome das classes que implementam a interface
        for (Class<? extends IOperation> clazz : classes) {
            System.out.println("Classe que implementa IOperation: " + clazz.getSimpleName());
        }
    }

    public static void showCalc(){
        try {
            //brincando com reflection
            Class<?> menu = Class.forName("br.ifes.projetoDeSistemas.calc.view.Menu");
            Object menuInstance = menu.getDeclaredConstructor().newInstance();
            RequestDTO requestDTO =(RequestDTO) menu.getMethod("showDTO").invoke(menuInstance);
            Class<?> controllerClass = Class.forName("br.ifes.projetoDeSistemas.calc.controller.ControllerCalc");
            Object controllerInstance = controllerClass.getDeclaredConstructor().newInstance();
            ResponseDTO responseDTO = (ResponseDTO) controllerClass.getMethod("calc", RequestDTO.class).invoke(controllerInstance, requestDTO);
            menu.getMethod("showResult", ResponseDTO.class).invoke(menuInstance, responseDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
