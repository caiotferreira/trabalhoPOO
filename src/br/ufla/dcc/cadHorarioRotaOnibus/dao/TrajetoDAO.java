/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import java.util.List;

/**
 * 
 * 
 * @author group
 */
public interface TrajetoDAO {
    
    public Trajeto obterTrajetoPeloID(String id);
    
    public void adicionarTrajeto(Trajeto trajeto);
    
    public void alterarTrajeto(Trajeto trajeto);
    
    public void removerTrajeto(int pos);
    
    public List<Trajeto> obterTodosTrajetos();
}
