/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.imagens;

import javax.swing.ImageIcon;

/**
 *
 * @author Acer
 */
public class GerenciadorDeImagens {
    // conjunto de ícones / imagens usadas no sistema.
    // Obs: atributos são públicos por serem constantes.
    
    public static final ImageIcon SAIR = carregarIcone("sair.png");
    public static final ImageIcon LOGOUT = carregarIcone("logout.png");
    public static final ImageIcon ENTRAR = carregarIcone("entrar.png");
    public static final ImageIcon NOVO = carregarIcone("novo.png");
    public static final ImageIcon EDITAR = carregarIcone("editar.png");
    public static final ImageIcon DELETAR = carregarIcone("deletar.png");
    public static final ImageIcon BANDEIRA_BR = carregarIcone("bandeira-br.png");
    public static final ImageIcon BANDEIRA_GB = carregarIcone("bandeira-gb.png");
    public static final ImageIcon CADASTRAR_USUARIO = carregarIcone("cadastrar-usuario.png");
    public static final ImageIcon OK = carregarIcone("btn-ok.png");
    public static final ImageIcon CANCELAR = carregarIcone("btn-cancelar.png");
    public static final ImageIcon SOBRE = carregarIcone("sobre.png");

    /**
     * Retorna um ícone (imagem) a partir do seu nome. Utilizado internamente 
     * acima no carregamento das imagens.
     * 
     * @param caminho Nome da imagem a ser carregada.
     * @return A imagem carregada.
     */
    private static ImageIcon carregarIcone(String caminho) {
        return new ImageIcon(GerenciadorDeImagens.class.getResource(caminho));
    }
}
