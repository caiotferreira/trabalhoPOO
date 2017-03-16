/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;

/**
 *
 * @author Danniel
 */
public interface OnibusDAO {
    
    public Onibus obterOnibusPeloID(String id);
    
    public void adicionarOnibus(Onibus onibus);
    
    public void removerOnibus(Onibus onibus);
    
    public void alterarOnibus(Onibus onibus, float novaKm);
}
