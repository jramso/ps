package com.br.ifes.application;

import com.br.ifes.model.LabirintoModel;
import com.br.ifes.view.LabirintoView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            File pastaFases = new File(System.getProperty("user.dir") + "/TPA/labirintoanimado/src/main/java/com/br/ifes/application/fases");
            JFileChooser fileChooser = new JFileChooser(pastaFases);
            fileChooser.setDialogTitle("Selecione a fase do labirinto (CSV)");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos CSV", "csv"));

            int userSelection = fileChooser.showOpenDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File arquivoSelecionado = fileChooser.getSelectedFile();
                String caminhoArquivo = arquivoSelecionado.getAbsolutePath();

                LabirintoModel modelo = new LabirintoModel();
                try {
                    modelo.carregarLabirinto(caminhoArquivo);
                    new LabirintoView(modelo.getLabirinto());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo: " + e.getMessage());
                }
            } else {
                System.out.println("Nenhuma fase selecionada.");
            }
        });
    }
}
