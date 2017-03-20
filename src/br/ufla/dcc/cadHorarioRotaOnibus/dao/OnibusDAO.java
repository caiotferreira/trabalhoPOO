/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import java.util.List;

/**
 *
 * @author group
 */
public interface OnibusDAO {
    
    public Onibus obterOnibusPeloID(String id);
    
    public void adicionarOnibus(Onibus onibus);
    
    public void removerOnibus(int pos);
    
    public void alterarOnibus(int pos, float km);
    
    public List<Onibus> obterTodosOnibus();
}
