/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.imagens.GerenciadorDeImagens;
import br.ufla.dcc.cadHorarioRotaOnibus.seguranca.SessaoUsuario;
import br.ufla.dcc.cadHorarioRotaOnibus.util.Utilidades;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
/**
 * Classe que representa a Tela Principal
 * 
 * @author Danniel
 */
public class TelaPrincipal {

    // objeto de controle de sessão (autenticação) do usuário
    private final SessaoUsuario sessaoUsuario;
    // tela de autenticação (login) de usuário
    private final TelaAutenticacao telaAutenticacao;
    // tela de autenticação (login) de usuário
    private final TelaCadastroOnibus telaCadastroOnibus;
    // tela de cadastro de usuário
    private final TelaCadastroUsuario telaCadastroUsuario;
    // tela de cadastro de trajeto
    private final TelaCadastroTrajeto telaCadastroTrajeto;
    // tela que exibe os onibus cadastrados
    private final TelaExibirOnibus telaExibirOnibus;
    // tela que exibe os trajetos cadastrados
    private final TelaExibirTrajeto telaExibirTrajeto;    
    
    // janela da tela principal
    private JFrame janela;
    
    // Menus principais da tela    
    private JMenuBar menuPrincipal;
    private JMenu menuInicio;
    private JMenu menuNavegar;
    private JMenu menuIdioma;
    private JMenu menuAjuda;
    
    // Submenus da tela
    private JMenuItem menuEntrar;
    private JMenuItem menuCadastrarUsuario;
    private JMenuItem menuIdiomaPortugues;
    private JMenuItem menuIdiomaIngles;
    private JMenuItem menuSair;
    private JMenuItem menuSobre;
    
    // Itens de menu específicos para usuários logados no sistema    
    private JMenuItem menuLogout;
    private JMenuItem menuCadastrarOnibus;
    private JMenuItem menuCadastrarTrajeto;
    private JMenuItem menuCadastrarRota;
    private JMenuItem menuListarOnibus;
    private JMenuItem menuListarTrajetos;
    
    /**
     * Construtor; incializa as demais telas e sessão de usuário.
     */
    public TelaPrincipal() {
        telaAutenticacao = new TelaAutenticacao(this);
        telaCadastroUsuario = new TelaCadastroUsuario(this);
        telaCadastroOnibus = new TelaCadastroOnibus(this);
        telaCadastroTrajeto = new TelaCadastroTrajeto(this);
        telaExibirOnibus = new TelaExibirOnibus(janela, true);
        telaExibirTrajeto = new TelaExibirTrajeto(janela, true);
        sessaoUsuario = SessaoUsuario.obterInstancia();
    }
    
    /**
     * Inicializa a tela
     */
    public void inicializar() {
        // Serve para o caso em que o usuário
        // decidiu mudar o idioma da aplicação.
        if (janela != null) {
            System.out.println("10");
            janela.dispose();
        }
        System.out.println("11");
        construirTela();
        System.out.println("12");
        configurarEventosTela();
        exibirTela();
    }
    
    /**
     * Configura os eventos da tela.
     */
    private void configurarEventosTela() {
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });

        menuIdiomaPortugues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.PT_BR);
                inicializar();
            }
        });
        
        menuIdiomaIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                I18N.alterarLocalidade(I18N.EN_US);
                inicializar();
            }
        });

        menuEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAutenticacao.inicializar();
            }
        });

        menuLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sessaoUsuario.invalidarSessao();
                inicializar();
            }
        });

        menuCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroUsuario.inicializar();
            }
        });

        menuSobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilidades.msgInformacao(I18N.obterMensagemSobre());
            }
        });

        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (Utilidades.msgConfirmacao(I18N.obterConfirmacaoSaida())) {
                    System.exit(0);
                }
            }
        });
        
    }
    
    private void configurarEventosOnline() {
        // metodo abre a tela de cadastro de onibus ao clicar no sub-menu
        // Cadastrar Onibus
        menuCadastrarOnibus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroOnibus.inicializar();
                
            }
        });
        
        menuListarOnibus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExibirOnibus.setVisible(true);
            }
        });
        
        // metodo abre a tela de cadastro de trajeto ao clicar no sub-menu
        // Cadastrar Trajeto
        menuCadastrarTrajeto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCadastroTrajeto.inicializar();
                
            }
        });
        
        menuListarTrajetos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaExibirTrajeto.setVisible(true);
            }
        });
        
        // metodo abre a tela de cadastro de rota ao clicar no sub-menu
        // Cadastrar Rota
//        menuCadastrarRota.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //telaCadastroRota.inicializar
//            }
//        });
    }
    
    /**
     * Contrói o Menu Início, trata internacionalização
     */
    private void construirMenuInicio() {
        menuInicio = new JMenu(I18N.obterMenuInicio());
        menuInicio.setMnemonic(I18N.obterMnemonicoMenuInicio());
        menuEntrar = new JMenuItem(I18N.obterMenuEntrar(), GerenciadorDeImagens.ENTRAR);
        menuCadastrarUsuario = new JMenuItem(I18N.obterMenuCadastrarUsuario(), GerenciadorDeImagens.CADASTRAR_USUARIO);
        menuLogout = new JMenuItem(I18N.obterMenuLogout(), GerenciadorDeImagens.LOGOUT);
        
        
        if (!sessaoUsuario.estahLogado()) {
            menuInicio.add(menuEntrar);
            menuInicio.add(menuCadastrarUsuario);
        } else {
            
            // Aqui você poderá adicionar outros itens de menu, se necessário.
            menuInicio.add(menuLogout);
            
        }

        menuSair = new JMenuItem(I18N.obterMenuSair(), GerenciadorDeImagens.SAIR);
        menuInicio.addSeparator();
        menuInicio.add(menuSair);
        menuPrincipal.add(menuInicio);
    }
    
    /**
     * Constrói o menu Navegar, AINDA NÃO trata internacionalização.
     */
    private void construirMenuNavegar() {
        menuNavegar = new JMenu("Navegar");
        menuCadastrarOnibus = new JMenuItem("Cadastrar Onibus");
        menuCadastrarTrajeto = new JMenuItem("Cadastrar Trajeto");
        menuCadastrarRota = new JMenuItem("Cadastrar Rota");
        menuListarOnibus = new JMenuItem("Exibir ônibus");
        menuNavegar.add(menuCadastrarOnibus);
        menuNavegar.add(menuCadastrarTrajeto);
        menuNavegar.add(menuCadastrarRota);
        menuNavegar.addSeparator();
        menuNavegar.add(menuListarOnibus);
        menuNavegar.add(menuListarTrajetos);
        menuPrincipal.add(menuNavegar);
    }
    
    /**
     * Constrói o menu Idioma, trata internacionalização.
     */
    private void construirMenuIdioma() {
        menuIdioma = new JMenu(I18N.obterMenuIdioma());
        menuIdioma.setMnemonic(I18N.obterMnemonicoMenuIdioma());
        menuIdiomaPortugues = new JMenuItem(I18N.obterMenuIdiomaPortugues(), GerenciadorDeImagens.BANDEIRA_BR);
        menuIdiomaIngles = new JMenuItem(I18N.obterMenuIdiomaIngles(), GerenciadorDeImagens.BANDEIRA_GB);
        menuIdioma.add(menuIdiomaPortugues);
        menuIdioma.add(menuIdiomaIngles);
        menuPrincipal.add(menuIdioma);
    }
    
    /**
     * Constrói o menu Ajuda, trata internacionalização.
     */
    private void construirMenuAjuda() {
        menuAjuda = new JMenu(I18N.obterMenuAjuda());
        menuAjuda.setMnemonic(I18N.obterMnemonicoMenuAjuda());
        menuSobre = new JMenuItem(I18N.obterMenuSobre(), GerenciadorDeImagens.SOBRE);
        menuAjuda.add(menuSobre);
        menuPrincipal.add(menuAjuda);
    }
    
    /**
     * Constrói o menu Usuário, trata internacionalização.
     */
    private void construirMenuUsuario() {
        menuPrincipal = new JMenuBar();
        construirMenuInicio();
        
        if (sessaoUsuario.estahLogado()) {
             // Aqui você poderá adicionar outros menus adequados
             // ao seu projeto que serão exibidos quando o
             // usuário estiver logado no sistema.
             construirMenuNavegar();
             configurarEventosOnline();
         }  
        
        construirMenuIdioma();
        construirMenuAjuda();
        janela.setJMenuBar(menuPrincipal);
        
    }
    
    /**
     * Constrói a tela.
     */
    private void construirTela() {
        janela = new JFrame(I18N.obterTituloTelaPrincipal());
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        construirMenuUsuario();
    }
    
    /**
     * Exibe a tela.
     */
    private void exibirTela() {
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Permite que apenas o botão de fechar esteja disponível na janela.        
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

        janela.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TelaPrincipal().inicializar();
    }
    
    /**
     * Retorna uma referência para a janela
     *
     * @return
     */
    public JFrame obterJanela() {
        return this.janela;
    }
    
}
