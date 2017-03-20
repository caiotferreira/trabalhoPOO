/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao.lista;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.RotaDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Rota;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import br.ufla.dcc.cadHorarioRotaOnibus.servicos.GerenciadorOnibus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class RotaDAOLista implements RotaDAO {

    // instância única da classe (Padrão de Projeto Singleton)
    private static RotaDAOLista instancia;
    
    // lista em em memória dos onibus cadastrados
    private final List<Rota> listaRotas;
    
    // lista em memória dos onibus cadastrados
//    private final List<Onibus> listaOnibus;
    private GerenciadorOnibus gerenciadorOnibus;
    
    // constroi o objeto 
    private RotaDAOLista () {
        listaRotas = new ArrayList<Rota>();
//        listaOnibus = new ArrayList<Onibus>();
        gerenciadorOnibus = new GerenciadorOnibus();
    }
    
    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static RotaDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new RotaDAOLista();
        }
        return instancia;
    }
    
    /**
     * Retorna a rota
     * 
     * @param id Id da rota ser retornadoa.
     * @return Rota correspondente ao id passado.
     */
    @Override
    public Rota obterRotaPeloID(String id) {
        for (Rota r : listaRotas) {
            if (id.equals(r.getId())) {
                return r;
            }
        }
        return null;
    }
    
    @Override
    public void adicionarRota(Rota rota, Onibus onibus, Horarios horarios, Trajeto trajeto) {
        listaRotas.add(rota);
    }

    @Override
    public void alterarRota(Rota rota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exlcuirRota(Rota rota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
