package com.br.ifes.application;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.br.ifes.controller.LabirintoController;
import com.br.ifes.model.LabirintoModel;
import com.br.ifes.view.LabirintoView;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o arquivo de labirinto (CSV)");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos CSV", "csv"));

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

            LabirintoModel modelo = new LabirintoModel();
            LabirintoView visao = new LabirintoView();
            LabirintoController controle = new LabirintoController(modelo, visao);

            try {
                modelo.carregarLabirinto(caminhoArquivo);
                controle.resolverLabirinto(caminhoArquivo);
            } catch (IOException e) {
                visao.exibirMensagem("Erro ao carregar o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum arquivo selecionado.");
        }
    }
}
