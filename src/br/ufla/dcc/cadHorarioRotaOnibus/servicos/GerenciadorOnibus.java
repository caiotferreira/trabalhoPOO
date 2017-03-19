/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.servicos;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.OnibusDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.dao.lista.OnibusDAOLista;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import java.util.List;

/**
 *
 * @author Acer
 */
public class GerenciadorOnibus {
    // atributo utilizado como camada de acesso a dados do cadastro de ônibus
    private final OnibusDAO repositorioOnibus;
    
     /**
     * Constroi o gerenciador de onibus, inicializando as camadas de acesso a 
     * dados e de sessão.
     */
    public GerenciadorOnibus() {
        repositorioOnibus
                = OnibusDAOLista.obterInstancia();
    }
    
    /**
     * Cadastra o ônibus passado no sistema.
     * 
     * @param onibus Ônibus a ser cadastrado.
     * @throws Exception Exceção gerada caso o usuário já esteja cadastrado.
     */
    public void cadastrarOnibus(Onibus onibus) throws Exception {
        Onibus ret = repositorioOnibus.obterOnibusPeloID(onibus.getId());
        if (ret != null) {
            //throw new Exception(I18N.obterErroUsuarioJaCadastrado());
        }
        repositorioOnibus.adicionarOnibus(onibus);
    }
    
    public void removerOnibus(Onibus onibus) throws Exception {
//        Onibus ret = repositorioOnibus.obterOnibusPeloID(onibus.getId());
//        if (ret != null) {
//            //throw new Exception(I18N.obterErroUsuarioJaCadastrado());
//        }
        
        repositorioOnibus.removerOnibus(onibus);
    }
    
    public List<Onibus> buscarOnibus() {
        return repositorioOnibus.obterTodosOnibus();
    }
}
