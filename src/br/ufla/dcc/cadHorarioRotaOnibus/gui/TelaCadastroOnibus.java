/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.i18n.I18N;
import br.ufla.dcc.cadHorarioRotaOnibus.imagens.GerenciadorDeImagens;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import br.ufla.dcc.cadHorarioRotaOnibus.servicos.GerenciadorOnibus;
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
 * Classe que representa a interface que cadastra ônibus
 * 
 * @author Acer
 */
public class TelaCadastroOnibus {
    // referência para a tela principal
    private final TelaPrincipal telaPrincipal;
    // referência para o gerenciador de usuários
    private final GerenciadorOnibus gerenciadorOnibus;
    
    // componentes da tela
    private JDialog janela;
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private JLabel lbID;
    private JLabel lbMarca;
    private JLabel lbModelo;
    private JLabel lbAno;
    private JLabel lbKm;
    private JLabel lbCapacidade;
    private JTextField txtID;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtAno;
    private JTextField txtKm;
    private JTextField txtCapacidade;
    private JButton btnSalvar;
    private JButton btnCancelar;
   
    /**
     * Constrói a tela de Cadastro de Ônibus guardando a referência da tela 
     * principal e criando o gerenciador de ônibus.
     * 
     * @param telaPrincipal Referência da tela principal.
     */
    public TelaCadastroOnibus(TelaPrincipal telaPrincipal) {
        this.gerenciadorOnibus = new GerenciadorOnibus();
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
    
    private void adicionarComponentes () {
        lbID = new JLabel("Registro de série");
        adicionarComponente(lbID,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                0, 0, 1, 1);
        
        lbMarca = new JLabel("Marca");
        adicionarComponente(lbMarca,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                1, 0, 1, 1);
        
        lbModelo = new JLabel("Modelo");
        adicionarComponente(lbModelo,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                2, 0, 1, 1);
        
        lbAno = new JLabel("Ano de fabricação");
        adicionarComponente(lbAno,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                3, 0, 1, 1);
        
        lbKm = new JLabel("Kilometragem rodada");
        adicionarComponente(lbKm,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                4, 0, 1, 1);
        
        lbCapacidade = new JLabel("Capacida máxima");
        adicionarComponente(lbCapacidade,
                GridBagConstraints.LINE_END,
                GridBagConstraints.NONE,
                5, 0, 1, 1);
        
        txtID = new JTextField(35);
        adicionarComponente(txtID,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                0, 1, 1, 1);

        txtMarca = new JTextField(35);
        adicionarComponente(txtMarca,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                1, 1, 1, 1);
        
        txtModelo = new JTextField(35);
        adicionarComponente(txtModelo,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                2, 1, 1, 1);
        
        txtAno = new JTextField(35);
        adicionarComponente(txtAno,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                3, 1, 1, 1);
        
        txtKm = new JTextField(35);
        adicionarComponente(txtKm,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                4, 1, 1, 1);
        
        txtCapacidade = new JTextField(35);
        adicionarComponente(txtCapacidade,
                GridBagConstraints.LINE_START,
                GridBagConstraints.NONE,
                5, 1, 1, 1);
        
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
     * Retorna um novo onibus 
     * 
     * @return Usuário criado.
     */
    private Onibus carregarOnibus() {
        return new Onibus(txtID.getText(),
                txtMarca.getText(),
                txtModelo.getText(),
                Integer.parseInt(txtAno.getText()),
                Integer.parseInt(txtKm.getText()),
                Integer.parseInt(txtCapacidade.getText()));
    }
    
    /**
     * Limpa os componentes da tela
     */
    private void limparTela() {
        txtID.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtAno.setText("");
        txtKm.setText("");
        txtCapacidade.setText("");
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

                    gerenciadorOnibus.cadastrarOnibus(carregarOnibus());
                    Utilidades.msgInformacao("Onibus cadastrado com sucesso!");
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
        janela.setTitle("Cadastro de Ônibus");
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
