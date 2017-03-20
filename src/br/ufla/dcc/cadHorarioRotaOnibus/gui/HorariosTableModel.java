/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.gui;

import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Horarios;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author group
 */
public class HorariosTableModel extends AbstractTableModel {
    
    private List<Horarios> horarios;
    private String[] colunas = new String[]{"Horário de Partida", "Horário estimado de chegada"};

    public HorariosTableModel() {
        horarios = new ArrayList<>();
    }
    
    public void limpaArrayHorarios() {
        horarios.clear();
    }
    
    public void adicionarHorarios(Horarios h) {
        this.horarios.add(h);
        this.fireTableDataChanged();
    }
    
    public void removerHorarios(int linha) {
        horarios.remove(linha);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return horarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0 : return horarios.get(linha).getPartida();
            case 1 : return horarios.get(linha).getChegadaEstimada();
        }
        return null;
    }
    public String getColumnName(int coluna) {
        return this.colunas[coluna];
    }
}
