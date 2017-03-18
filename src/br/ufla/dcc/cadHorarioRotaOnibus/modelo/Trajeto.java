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
public class Trajeto {
    
    private final String idTrajeto;
    private String trajeto;
    
    public Trajeto(String idTrajeto, String trajeto) {
        this.idTrajeto = idTrajeto;
        this.trajeto = trajeto;
    }
    
    public String getIdTrajeto() {
        return idTrajeto;
    }

    public String getDescricao() {
        return trajeto;
    }
}
