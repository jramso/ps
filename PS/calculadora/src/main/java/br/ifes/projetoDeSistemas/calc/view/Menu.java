package br.ifes.projetoDeSistemas.calc.view;

import java.util.Scanner;

import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;
import br.ifes.projetoDeSistemas.calc.dto.ResponseDTO;

public class Menu {

    public RequestDTO show(){
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
    }

}
