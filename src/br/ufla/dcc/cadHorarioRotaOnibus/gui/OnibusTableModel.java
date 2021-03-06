/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author group
 */
public class OnibusTableModel extends AbstractTableModel {
    
    private List<Onibus> onibus;
    private String[] colunas = new String[]{"Identificador", "Marca", "Modelo", "Ano", "Km", "Capacidade"};
    
    public OnibusTableModel() {
        onibus = new ArrayList<>();
    }
    
    public void limpaArrayOnibus() {
        onibus.clear();
    }
    
    public void adicionarOnibus(Onibus o) {
        this.onibus.add(o);
        this.fireTableDataChanged();
    }
    
    public void removerOnibus(int linha) {
        this.onibus.remove(linha);
        this.fireTableDataChanged();
    }
    
    public void atualizaTabela() {
        this.fireTableDataChanged();
    }
    
    public List<Onibus> buscarTodosOnibus () {
        return onibus;
    }
    
    public Onibus buscarOnibusPeloId(String id) {
        for (Onibus o : onibus) {
            if (id.equals(o.getId())) {
                System.out.println("achei o busao");
                return o;
            }
        }
        return null;
    }
    
    @Override
    public int getRowCount() {
        return onibus.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0: return onibus.get(linha).getId();
            case 1: return onibus.get(linha).getMarca();
            case 2: return onibus.get(linha).getModelo();
            case 3: return onibus.get(linha).getAno();
            case 4: return onibus.get(linha).getKm();
            case 5: return onibus.get(linha).getCapacidade();
        }
        return null;
    }
    
    public String getColumnName(int coluna) {
        return this.colunas[coluna];
    }
    
    public String buscarId(int linha){
        return this.onibus.get(linha).getId();
    }
}
