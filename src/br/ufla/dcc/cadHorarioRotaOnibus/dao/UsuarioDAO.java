/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Usuario;

/**
 *
 * @author Acer
 */
public interface UsuarioDAO {
    /**
     * Retorna o usuário a partir de seu login
     * 
     * @param login Login do usuário a ser retornado.
     * @return Usuário correspondente ao login passado.
     */
    public Usuario obterUsuarioPeloLogin(String login);
    
    /**
     * Cadastra o usuário passado.
     * 
     * @param usuario Usuário a ser cadastrado.
     */
    public void adicionarUsuario(Usuario usuario);
}
