package com.br.ifes.controller;

import java.io.IOException;

import com.br.ifes.model.LabirintoModel;
import com.br.ifes.view.LabirintoView;

public class LabirintoController {
    private LabirintoModel modelo;
    private LabirintoView visao;

    public LabirintoController(LabirintoModel modelo, LabirintoView visao) {
        this.modelo = modelo;
        this.visao = visao;
    }

    public void resolverLabirinto(String arquivo) {
        try {
            modelo.carregarLabirinto(arquivo);
            if (modelo.buscarCaminho(0, 0)) {
                visao.exibirMensagem("Caminho encontrado:");
                visao.exibirLabirinto(modelo.getLabirinto());
            } else {
                visao.exibirMensagem("Não há caminho para a saída.");
            }
        } catch (IOException e) {
            visao.exibirMensagem("Erro ao carregar o labirinto: " + e.getMessage());
        }
    }
}
