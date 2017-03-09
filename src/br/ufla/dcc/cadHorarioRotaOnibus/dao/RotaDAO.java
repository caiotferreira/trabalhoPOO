/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Rota;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;

/**
 *
 * @author Acer
 */
public interface RotaDAO {
    
    public void criaRota (Rota rota, Onibus onibus, Horarios horarios, Trajeto trajeto);
    
    public void alteraRota (Rota rota);
    
}
