/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.modelo;

import java.util.ArrayList;

/**
 *
 * @author Danniel
 */
public class Trajeto extends Rota {
    
    private ArrayList trajeto;
    
    public Trajeto(ArrayList trajeto, int id, String descricao, String origem, String destino) {
        super(id, descricao, origem, destino);
        this.trajeto = trajeto;
    }
    
}
