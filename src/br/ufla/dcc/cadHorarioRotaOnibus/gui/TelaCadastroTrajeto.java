/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.imagens.GerenciadorDeImagens;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import br.ufla.dcc.cadHorarioRotaOnibus.servicos.GerenciadorTrajetos;
import br.ufla.dcc.cadHorarioRotaOnibus.util.Utilidades;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Acer
 */
public class TelaCadastroTrajeto {
    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
    // referência para o gerenciador de trajetos
    private final GerenciadorTrajetos gerenciadorTrajetos;
    
    /**
     * Constrói a tela de Cadastro de Ônibus guardando a referência da tela 
     * principal e criando o gerenciador de ônibus.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaCadastroTrajeto(TelaPrincipal telaPrincipal) {
        this.gerenciadorTrajetos = new GerenciadorTrajetos();
        this.telaPrincipal = telaPrincipal;
    }
    
    // componentes da tela
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JLabel lbID;
    private JLabel lbDescricao;
    private JTextField txtID;
    private JTextField txtDescricao;
    private JButton btnSalvar;
    private JButton btnCancelar;
    
    /**
     * Inicializa a tela, construindo seus componentes, configurando os eventos
     * e, ao final, exibe a tela.
     */
    public void inicializar() {
        construirTela();
        configurarAcaoBotoes();
        exibirTela();
    }
    
    /**
     * Adiciona um componente à tela.
     */
    private void adicionarComponente(Component c,
            int anchor, int fill, int linha,
            int coluna, int largura, int altura) {
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridwidth = largura;
        gbc.gridheight = altura;
        gbc.insets = new Insets(5, 5, 5, 5);
        layout.setConstraints(c, gbc);
        janela.add(c);
    }
    
    private void adicionarComponentes() {
        lbID = new JLabel("ID");
        adicionarComponente(lbID,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);
        
        lbDescricao = new JLabel("Descricao");
        adicionarComponente(lbDescricao,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);
        
        txtID = new JTextField(35);
        adicionarComponente(txtID,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);
        
        txtDescricao = new JTextField(35);
        adicionarComponente(txtDescricao,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);
        
        btnSalvar = new JButton(I18N.obterBotaoSalvar(),
                GerenciadorDeImagens.OK);
        
        btnCancelar = new JButton(I18N.obterBotaoCancelar(),
                GerenciadorDeImagens.CANCELAR);
        
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);
        
        adicionarComponente(painelBotoes,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,
                7, 0, 2, 1);
    }
    
    /**
     * Retorna um novo trajeto a partir do 
     * 
     * @return Trajeto criado.
     */
    private Trajeto carregarTrajeto() {
        return new Trajeto(txtID.getText(),
                txtDescricao.getText());
    }
    
    /**
     * Limpa os componentes da tela
     */
    private void limparTela() {
        txtID.setText("");
        txtDescricao.setText("");
        txtID.requestFocus();
    }
    
    private String getTxtID () {
        return txtID.getText();
    }
    
    /**
     * Configura os eventos dos botões.
     */
    private void configurarAcaoBotoes () {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });
        
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
//                    if ((getTxtID()) != null) {
//                        throw new Exception();
//                    }

                    gerenciadorTrajetos.cadastrarTrajeto(carregarTrajeto());
                    Utilidades.msgInformacao(I18N.obterSucessoCadastroUsuario());
                    limparTela();
                } catch (Exception ex) {
                    Utilidades.msgErro(ex.getMessage());
                }

            }
        });
    }
    
    /**
     * Constrói a janela tratando internacionalização, componentes e layout.
     */
    private void construirTela() {
        janela = new JDialog();
        janela.setTitle("Cadastro de Trajetos");
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        janela.setLayout(layout);
        adicionarComponentes();        
        janela.pack();
    }
    
    /**
     * Exibe a tela.
     */
    public void exibirTela() {
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setLocationRelativeTo(telaPrincipal.obterJanela());
        janela.setModal(true);
        janela.setVisible(true);
        janela.setResizable(false);
    }
}
