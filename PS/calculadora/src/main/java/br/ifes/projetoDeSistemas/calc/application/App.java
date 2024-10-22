package br.ifes.projetoDeSistemas.calc.application;

import br.ifes.projetoDeSistemas.calc.view.Menu;




public class App 
{
    public static void main(String[] args) {
        
        System.out.println("REFLECTION:");
        Menu.show();

        System.out.println("\n Execução da Calculadora");
        Menu.showCalc();
    }
}
