/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Trajeto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author group
 */
public class TrajetosTableModel extends AbstractTableModel{
    
    private List<Trajeto> trajeto;
    private String[] colunas = new String[]{"Identificador", "Descrição"};
    
    public TrajetosTableModel() {
        trajeto = new ArrayList();
    }
    
    public void adicionarTrajeto(Trajeto t){
        this.trajeto.add(t);
        this.fireTableDataChanged();
    }
    
    public void removerTrajeto(int linha) {
        this.trajeto.remove(linha);
        this.fireTableDataChanged();
    }
   
    public void atualizaTabela() {
        this.fireTableDataChanged();
    }
    
    public void limpaArrayTrajetos() {
        trajeto.clear();
    }
    
    @Override
    public int getRowCount() {
        return trajeto.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna) {
            case 0: return trajeto.get(linha).getIdTrajeto();
            case 1: return trajeto.get(linha).getDescricao();
        }
        return null;
    }

    public String getColumnName(int coluna) {
        return this.colunas[coluna];
    }
    
    public String buscarId(int linha){
        return this.trajeto.get(linha).getIdTrajeto();
    }
}
