/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.servicos;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.TrajetoDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.dao.lista.TrajetoDAOLista;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import java.util.List;

/**
 *
 * @author group
 */
public class GerenciadorTrajetos {
    // atributo utilizado como camada de acesso a dados do cadastro de usuários
    private final TrajetoDAO repositorioTrajeto;
    
    /**
     * Constroi o gerenciador de usuários, inicializando as camadas de acesso a 
     * dados e de sessão.
     */
    public GerenciadorTrajetos() {
        repositorioTrajeto
                = TrajetoDAOLista.obterInstancia();
    }
    
    /**
     * Cadastra o trajeto passado no sistema.
     * 
     * @param trajeto Trajeto a ser cadastrado.
     * @throws Exception Exceção gerada caso o usuário já esteja cadastrado.
     */
    public void cadastrarTrajeto(Trajeto trajeto) throws Exception {
        Trajeto ret = repositorioTrajeto.obterTrajetoPeloID(trajeto.getIdTrajeto());
        if (ret != null) {
            //throw new Exception(I18N.obterErroUsuarioJaCadastrado());
        }
        repositorioTrajeto.adicionarTrajeto(trajeto);
    }
    
    public void removerTrajeto(int pos) {
        repositorioTrajeto.removerTrajeto(pos);
    }
    
    public List<Trajeto> buscarTrajeto() {
        return repositorioTrajeto.obterTodosTrajetos();
    }
    
    public Trajeto buscarTrajetoPeloIndex(String id) {
        return repositorioTrajeto.obterTrajetoPeloID(id);
    }
}
