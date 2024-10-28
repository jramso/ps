package com.br.ifes.view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LabirintoView extends JFrame {
    private JPanel[][] cells;
    private int[][] labirinto;
    private int playerRow, playerCol;
    private boolean[][] visitado; // Matriz de células visitadas
    private Random random = new Random();

    public LabirintoView(int[][] labirinto) {
        this.labirinto = labirinto;
        this.cells = new JPanel[labirinto.length][labirinto[0].length];
        this.visitado = new boolean[labirinto.length][labirinto[0].length]; // Inicializa matriz visitado
        initUI();
        iniciarAnimacao();
    }

    private void initUI() {
        setLayout(new GridLayout(labirinto.length, labirinto[0].length));
        setTitle("Labirinto com Movimentação Aleatória");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                cells[i][j] = new JPanel();
                if (labirinto[i][j] == 0) {
                    cells[i][j].setBackground(Color.BLACK); // Parede
                } else {
                    cells[i][j].setBackground(Color.WHITE); // Caminho
                }
                add(cells[i][j]);
            }
        }

        // Define a posição inicial do jogador em uma célula de passagem
        do {
            playerRow = random.nextInt(labirinto.length);
            playerCol = random.nextInt(labirinto[0].length);
        } while (labirinto[playerRow][playerCol] == 0); // Evita paredes

        cells[playerRow][playerCol].setBackground(Color.RED);
        visitado[playerRow][playerCol] = true; // Marca a posição inicial como visitada
        setVisible(true);
    }

    private void iniciarAnimacao() {
        Timer timer = new Timer(500, e -> moverJogador());
        timer.start();
    }

    private void moverJogador() {
        int novaLinha = playerRow;
        int novaColuna = playerCol;
        int direcao = random.nextInt(4);

        switch (direcao) {
            case 0 -> novaLinha--; // cima
            case 1 -> novaLinha++; // baixo
            case 2 -> novaColuna--; // esquerda
            case 3 -> novaColuna++; // direita
        }

        if (novaLinha >= 0 && novaLinha < labirinto.length &&
            novaColuna >= 0 && novaColuna < labirinto[0].length &&
            labirinto[novaLinha][novaColuna] == 1) {

            cells[playerRow][playerCol].setBackground(Color.WHITE);
            playerRow = novaLinha;
            playerCol = novaColuna;
            cells[playerRow][playerCol].setBackground(Color.RED);
        }
    }

    public void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem);
    }
}
