/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.dao.lista;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.UsuarioDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group
 */
public class UsuarioDAOLista implements UsuarioDAO{
    // instância única da classe (Padrão de Projeto Singleton)
    private static UsuarioDAOLista instancia;
    
    // lista em em memória dos usuários cadastrados
    private final List<Usuario> listaUsuario;

    /**
     * Constrói o objeto já definindo 5 usuários padrões
     */
    private UsuarioDAOLista() {
        listaUsuario = new ArrayList<Usuario>();

        // Cadastrei alguns usuários para testar o programa.
        char[] senha = new char[]{'1', '2', '3'};
        listaUsuario.add(new Usuario("caio", senha, "Caio"));
        listaUsuario.add(new Usuario("danniel", senha, "Danniel"));
        listaUsuario.add(new Usuario("luiz", senha, "Luiz"));
    }

    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static UsuarioDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDAOLista();
        }
        return instancia;
    }

    /**
     * Retorna o usuário a partir de seu login
     * 
     * @param login Login do usuário a ser retornado.
     * @return Usuário correspondente ao login passado.
     */
    @Override
    public Usuario obterUsuarioPeloLogin(String login) {
        for (Usuario u : listaUsuario) {
            if (login.equals(u.obterLogin())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Cadastra o usuário passado.
     * 
     * @param usuario Usuário a ser cadastrado.
     */
    @Override
    public void adicionarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }
}
