/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.servicos;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.HorariosDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.dao.lista.HorarioDAOLista;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import java.util.List;

/**
 *
 * @author group
 */
public class GerenciadorHorarios {
    // atributo utilizado como camada de acesso a dados do cadastro de horários
    private final HorariosDAO repositorioHorarios;
    
    /**
     * Constroi o gerenciador de horarios, inicializando as camadas de acesso a 
     * dados e de sessão.
     */
    public GerenciadorHorarios() {
        repositorioHorarios
                = HorarioDAOLista.obterInstancia();
    }
    
    /**
     * Cadastra o ônibus passado no sistema.
     * 
     * @param horarios Horarios a serem cadastrados.
     * @throws Exception Exceção gerada caso o usuário já esteja cadastrado.
     */
    public void cadastrarHorarios(Horarios horarios) throws Exception {
//        Horarios ret = repositorioHorarios.obterOnibusPeloID(onibus.getId());
//        if (ret != null) {
//            //throw new Exception(I18N.obterErroUsuarioJaCadastrado());
//        }
        repositorioHorarios.adicionarHorarios(horarios);
    }
    
    public void removerHorarios(int pos) throws Exception {
//        Horarios ret = repositorioHorarios.obterOnibusPeloID(onibus.getId());
//        if (ret != null) {
//            //throw new Exception(I18N.obterErroUsuarioJaCadastrado());
//        }
        repositorioHorarios.excluirHorario(pos);
    }
    
    public List<Horarios> buscarHorarios() {
        return repositorioHorarios.obterTodosHorarios();
    }
}
