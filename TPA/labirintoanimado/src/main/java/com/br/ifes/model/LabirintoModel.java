package com.br.ifes.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LabirintoModel {
    private int[][] labirinto;
    private boolean[][] visitado;
    private final int[][] direcoes = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Direções: direita, baixo, esquerda, cima

    // Carrega o labirinto a partir de um arquivo CSV
    public void carregarLabirinto(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        int linhas = 0;
        int colunas = 0;

        // Conta o tamanho da matriz lendo o arquivo
        while ((linha = br.readLine()) != null) {
            String[] valores = linha.split(",");
            colunas = valores.length;
            linhas++;
        }
        br.close();

        // Inicializa o labirinto e a matriz de visitados
        labirinto = new int[linhas][colunas];
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

        visitado = new boolean[linhas][colunas]; // Inicializa a matriz de células visitadas
    }

    // Método recursivo para buscar o caminho até a saída
    public boolean buscarCaminho(int x, int y) {
        // Verifica limites e se a célula é válida para o caminho
        if (x < 0 || y < 0 || x >= labirinto.length || y >= labirinto[0].length || labirinto[x][y] == 0 || visitado[x][y]) {
            return false;
        }

        // Marca como visitado e parte do caminho
        visitado[x][y] = true;
        labirinto[x][y] = 2; // Marca o caminho percorrido com o valor 2 (para a visualização)

        // Se alcança a saída, termina a busca
        if (x == labirinto.length - 1 && y == labirinto[0].length - 1) {
            return true;
        }

        // Tenta mover-se nas direções: direita, baixo, esquerda, cima
        for (int[] direcao : direcoes) {
            int novoX = x + direcao[0];
            int novoY = y + direcao[1];
            if (buscarCaminho(novoX, novoY)) {
                return true;
            }
        }

        // Reseta a célula se não faz parte do caminho final
        labirinto[x][y] = 1; // Retorna a célula ao valor original
        visitado[x][y] = false;
        return false;
    }

    public int[][] getLabirinto() {
        return labirinto;
    }
}
