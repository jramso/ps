package com.ifes.view;

public class LabirintoView {

    public void exibirLabirinto(int[][] labirinto) {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                if (labirinto[i][j] == 2) {
                    System.out.print("X ");
                } else {
                    System.out.print((labirinto[i][j] == 1 ? "1 " : "0 "));
                }
            }
            System.out.println();
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
