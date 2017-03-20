/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao.lista;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.HorariosDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do Data Access Object (Padrão de Projeto) de Horarios através de
 * lista em memória
 * 
 * @author group
 */
public class HorarioDAOLista implements HorariosDAO {

    // instância única da classe (Padrão de Projeto Singleton)
    private static HorarioDAOLista instancia;
    // lista em em memória dos horários cadastrados
    private final List<Horarios> listaHorarios;
    
    // constroi o objeto 
    public HorarioDAOLista () {
        listaHorarios = new ArrayList<Horarios>();
    }
    
    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static HorarioDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new HorarioDAOLista();
        }
        return instancia;
    }
    
    @Override
    public void adicionarHorarios(Horarios horarios) {
        listaHorarios.add(horarios);
    }

    @Override
    public void alterarHorarios(Horarios horarios) {
        
    }

    @Override
    public void excluirHorario(int pos) {
        listaHorarios.remove(pos);
    }
    
    public List<Horarios> obterTodosHorarios() {
        return listaHorarios;
    }
    
}
