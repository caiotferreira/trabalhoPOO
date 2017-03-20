/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.modelo;

/**
 *
 * @author group
 */
public class Rota {
    private int id;
    private String descricao;
    private String origem;
    private String destino;

    public Rota(int id, String descricao, String origem, String destino) {
        this.id = id;
        this.descricao = descricao;
        this.origem = origem;
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }
}