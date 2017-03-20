/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.imagens.GerenciadorDeImagens;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import br.ufla.dcc.cadHorarioRotaOnibus.servicos.GerenciadorHorarios;
import br.ufla.dcc.cadHorarioRotaOnibus.util.Utilidades;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
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
 * Classe que representa a interface que cadastra horários
 * 
 * @author group
 */
public class TelaCadastroHorarios {
    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
    // referência para o gerenciador de usuários
    private final GerenciadorHorarios gerenciadorHorarios;
    
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JLabel lbPartida;
    private JLabel lbChegada;
    private JTextField txtPartida;
    private JTextField txtChegada;
    private JButton btnSalvar;
    private JButton btnCancelar;
    
    /**
     * Constrói a tela de Cadastro de Horários guardando a referência da tela 
     * principal e criando o gerenciador de horários.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaCadastroHorarios(TelaPrincipal telaPrincipal) {
        this.gerenciadorHorarios = new GerenciadorHorarios();
        this.telaPrincipal = telaPrincipal;
    }
    
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
        lbPartida = new JLabel("Horário de partida");
        adicionarComponente(lbPartida,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);
        
        lbChegada = new JLabel("Horário extimado de chegada");
        adicionarComponente(lbChegada,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);
        
        txtPartida = new JTextField(35);
        adicionarComponente(txtPartida,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);
        
        txtChegada = new JTextField(35);
        adicionarComponente(txtChegada,
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
     * Retorna os novos horarios
     * 
     * @return Horarios criados.
     */
    private Horarios carregarHorarios() {
        return new Horarios(txtPartida.getText(),
                txtChegada.getText());
    }
    
    /**
     * Limpa os componentes da tela
     */
    private void limparTela() {
        txtPartida.setText("");
        txtChegada.setText("");
        txtPartida.requestFocus();
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
                    gerenciadorHorarios.cadastrarHorarios(carregarHorarios());
                    Utilidades.msgInformacao("Horarios cadastrados com sucesso!");
                    limparTela();
                    janela.dispose();
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
        janela.setTitle("Cadastro de Horários");
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
