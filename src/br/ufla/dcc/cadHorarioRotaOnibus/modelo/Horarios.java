/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author group
 */
public class Horarios {
    //horario de partida 
    private String partida;
    //horario estimado da chegada
    private String chegadaEstimada;
    
    /**
     * Constroi um horario de uma rota a partir do seu horario de partida 
     * e horario estimado de chegada.
     * 
     * @param partida Horario de Partida
     * @param chegadaEstimada Horario estimado de chegada
     */
    public Horarios(String partida, String chegadaEstimada) {
        this.partida = partida;
        this.chegadaEstimada = chegadaEstimada;
    }
    

    /**
     * 
     * @return O horario de partida.
     */
    public String getPartida() {
        return partida;
    }

    /**
     * 
     * @param partida Altera o horario de partida.
     */
    public void setPartida(String partida) {
        this.partida = partida;
    }

    /**
     * 
     * @return O horário estimado de chegada.
     */
    public String getChegadaEstimada() {
        return chegadaEstimada;
    }
    
    /**
     * 
     * @param chegadaEstimada Altera o horario estimado de chegada.
     */
    public void setChegadaEstimada(String chegadaEstimada) {
        this.chegadaEstimada = chegadaEstimada;
    }
}
