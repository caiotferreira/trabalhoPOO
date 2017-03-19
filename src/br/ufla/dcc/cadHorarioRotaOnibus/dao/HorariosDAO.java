/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import java.util.List;

/**
 *
 * @author Acer
 */
public interface HorariosDAO {
    
    public void adicionarHorarios(Horarios horarios);
    
    public void alterarHorarios(Horarios horarios);
    
    public void excluirHorario(Horarios horarios);
    
    public List<Horarios> obterTodosHorarios();
    
}
