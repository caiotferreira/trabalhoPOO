/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.servicos;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.UsuarioDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.dao.lista.UsuarioDAOLista;
import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Usuario;
import br.ufla.dcc.cadHorarioRotaOnibus.seguranca.SessaoUsuario;

/**
 *
 * @author Acer
 */
public class GerenciadorUsuarios {
    
    // atributo utilizado como camada de acesso a dados do cadastro de usuários
    private final UsuarioDAO repositorioUsuario;
    // atributo para controle de sessão (autenticação do usuário)
    private final SessaoUsuario sessaoUsuario;

    /**
     * Constroi o gerenciador de usuários, inicializando as camadas de acesso a 
     * dados e de sessão.
     */
    public GerenciadorUsuarios() {
        repositorioUsuario = UsuarioDAOLista.obterInstancia();
        sessaoUsuario= SessaoUsuario.obterInstancia();
    }

    /**
     * Tenta autenticar o usuário passado no sistema.
     * 
     * @param usuario Usuário a ser autenticado
     * @throws Exception Exceção gerada caso o usuário não possa ser autenticado,
     * ou seja, usuário não existe ou senha incorreta.
     */
    public void autenticarUsuario(Usuario usuario) throws Exception {
        System.out.println("3");
        Usuario usuarioCadastrado = 
                repositorioUsuario.obterUsuarioPeloLogin(usuario.obterLogin());
        System.out.println("4");
        sessaoUsuario.alterarUsuario(usuarioCadastrado, usuario.obterSenha());
        System.out.println("8");
    }

    /**
     * Cadastra o usuário passado no sistema.
     * 
     * @param usuario Usuário a ser cadastrado.
     * @throws Exception Exceção gerada caso o usuário já esteja cadastrado.
     */
    public void cadastrarUsuario(Usuario usuario) throws Exception {
        Usuario ret = repositorioUsuario.obterUsuarioPeloLogin(usuario.obterLogin());
        if (ret != null) {
            throw new Exception(I18N.obterErroUsuarioJaCadastrado());
        }
        repositorioUsuario.adicionarUsuario(usuario);
    }
}
