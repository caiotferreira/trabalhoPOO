/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.seguranca;

import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Usuario;
import java.util.Arrays;

/**
 *
 * @author Acer
 */
public class SessaoUsuario {
    // instância única da classe (Padrão de Projeto Singleton)
    private static SessaoUsuario instancia;
    // usuário autenticado
    private Usuario usuario;
    
    /**
     * A princípio construtor não faz nada
     */
    private SessaoUsuario() {}
    
    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static SessaoUsuario obterInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }
    
    /**
     * Retorna o usuário atualmente logado.
     * 
     * @return O usuário logado
     */
    public Usuario obterUsuario() {
        return this.usuario;
    }
    
    /**
     * Indica se existe algum usuário logado.
     *
     * @return True se existe usuário logado.
     */
    public boolean estahLogado() {
        return (this.usuario != null);
    } 
   
    /**
     * Altera o usuário atualmente logado, verificando sua senha.
     * 
     * @param usuario Novo usuário logado.
     * @throws Exception Exceção gerada caso o usuário não possa ser autenticado,
     * ou seja, usuário não existe ou senha incorreta.
     */
    public void alterarUsuario(Usuario usuario, char[] senha) throws Exception {
        if (usuario == null || !Arrays.equals(usuario.obterSenha(), senha)) {
            throw new Exception(I18N.obterErroAutenticacao());
        }
        else {
            this.usuario = usuario;
        }
    }
    
    /**
     * Finaliza a sessão (não deixa nenhum usuário logado).
     */
    public void invalidarSessao() {
        this.usuario = null;
    }
}
