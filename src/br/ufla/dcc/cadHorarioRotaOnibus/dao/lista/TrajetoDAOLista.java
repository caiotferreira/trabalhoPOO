/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao.lista;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.TrajetoDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class TrajetoDAOLista implements TrajetoDAO {
    
    // instância única da classe (Padrão de Projeto Singleton)
    private static TrajetoDAOLista instancia;
    
    // lista em em memória dos onibus cadastrados
    private final List<Trajeto> listaTrajeto;
    
    // constroi o objeto 
    private TrajetoDAOLista () {
        listaTrajeto = new ArrayList<Trajeto>();
    }
    
    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static TrajetoDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new TrajetoDAOLista();
        }
        return instancia;
    }

    /**
     * Retorna o onibus a partir de seu login
     * 
     * @param id Id do ônibus a ser retornado.
     * @return Onibus correspondente ao id passado.
     */
    @Override
    public Trajeto obterTrajetoPeloID(String id) {
        for (Trajeto t : listaTrajeto) {
            if (id.equals(t.getIdTrajeto())) {
                return t;
            }
        }
        return null;
    }
    
    /**
     * Cadastra o trajeto passado.
     * 
     * @param trajeto Trajeto a ser cadastrado.
     */
    @Override
    public void adicionarTrajeto(Trajeto trajeto) {
        listaTrajeto.add(trajeto);
    }

    @Override
    public void alterarTrajeto(Trajeto trajeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerTrajeto(Trajeto trajeto) {
        listaTrajeto.remove(trajeto);
    }

    @Override
    public List<Trajeto> obterTodosTrajetos() {
        return listaTrajeto;
    }
    
}
