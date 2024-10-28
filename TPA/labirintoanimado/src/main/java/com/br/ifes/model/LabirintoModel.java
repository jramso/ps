package com.br.ifes.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LabirintoModel {
    private int[][] labirinto;
    private boolean[][] visitado;
    // {0, 1}: pra a direita.
    // {1, 0}: pra baixo.
    // {0, -1}: pra a esquerda.
    // {-1, 0}: pra cima.
    private final int[][] direcoes = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean caminhoEncontrado = false;
    private int tamanho;

    public void carregarLabirinto(String arquivo) throws IOException {
        // Primeiro passo: determinar o tamanho da matriz
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        int linhas = 0;
        int colunas = 0;

        // Conta as linhas e colunas no arquivo
        while ((linha = br.readLine()) != null) {
            String[] valores = linha.split(",");
            colunas = valores.length;
            linhas++;
        }
        br.close();

        // Inicializa as matrizes labirinto e visitado com o tamanho descoberto
        this.tamanho = linhas;
        this.labirinto = new int[linhas][colunas];
        this.visitado = new boolean[linhas][colunas];

        // Segundo passo: carrega o labirinto na matriz
        br = new BufferedReader(new FileReader(arquivo));
        int row = 0;
        while ((linha = br.readLine()) != null) {
            String[] valores = linha.split(",");
            for (int col = 0; col < valores.length; col++) {
                labirinto[row][col] = Integer.parseInt(valores[col]);
            }
            row++;
        }
        br.close();
    }

    public boolean buscarCaminho(int x, int y) {
        if (x < 0 || y < 0 || x >= tamanho || y >= tamanho || labirinto[x][y] == 0 || visitado[x][y]) {
            return false;
        }

        visitado[x][y] = true;
        labirinto[x][y] = 2; // Marca o caminho com "2"

        if (x == tamanho - 1 && y == tamanho - 1) {
            caminhoEncontrado = true;
            return true;
        }

        for (int[] d : direcoes) {
            int novoX = x + d[0];
            int novoY = y + d[1];
            if (buscarCaminho(novoX, novoY)) {
                return true;
            }
        }

        if (!caminhoEncontrado) {
            labirinto[x][y] = 1;
        }

        return false;
    }

    public int[][] getLabirinto() {
        return labirinto;
    }
}


