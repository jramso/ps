package com.br.ifes.controller;

import com.br.ifes.model.LabirintoModel;
import com.br.ifes.view.LabirintoView;

public class LabirintoController {
    private LabirintoModel modelo;
    private LabirintoView visao;

    public LabirintoController(LabirintoModel modelo, LabirintoView visao) {
        this.modelo = modelo;
        this.visao = visao;
    }

    public void resolverLabirinto() {
        if (modelo.buscarCaminho(0, 0)) {
            visao.exibirMensagem("Caminho encontrado!");
        } else {
            visao.exibirMensagem("Não há caminho para a saída.");
        }
    }
}
