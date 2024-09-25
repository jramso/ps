package br.ifes.projetoDeSistemas.calc.view;

import java.util.Scanner;

import br.ifes.projetoDeSistemas.calc.dto.RequestDTO;

public class Menu {

    public void show(){
        this.showMenu();
        //return this.captureValues();
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

    private void captureValues(){
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        System.out.println("Informe o primeiro valor:");
        int valor1 = entrada.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = entrada.nextInt();

        //return new RequestDTO(opcao,valor1,valor2);
    }

}
