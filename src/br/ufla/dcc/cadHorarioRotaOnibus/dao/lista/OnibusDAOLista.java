package br.ufla.dcc.cadHorarioRotaOnibus.dao.lista;

import br.ufla.dcc.cadHorarioRotaOnibus.dao.OnibusDAO;
import br.ufla.dcc.cadHorarioRotaOnibus.modelo.Onibus;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementação do Data Access Object (Padrão de Projeto) do Onibus através de
 * lista em memória
 * 
 * @author Caio Ferreira, Danniel Lucas e Luiz Amaral
 */
public class OnibusDAOLista implements OnibusDAO{

    // instância única da classe (Padrão de Projeto Singleton)
    private static OnibusDAOLista instancia;
    
    // lista em em memória dos onibus cadastrados
    private final List<Onibus> listaOnibus;
    
    // constroi o objeto 
    private OnibusDAOLista () {
        listaOnibus = new ArrayList<Onibus>();
    }
    
    /**
     * Retorna a instância única da classe (Padrão de Projeto Singleton)
     * 
     * @return A instância única da classe
     */
    public static OnibusDAOLista obterInstancia() {
        if (instancia == null) {
            instancia = new OnibusDAOLista();
        }
        return instancia;
    }
    
    /**
     * Retorna o onibus a partir de seu login
     * 
     * @param id Id do ônibus a ser retornado.
     * @return Onibus correspondente ao id passado.
     */
    @Override
    public Onibus obterOnibusPeloID(String id) {
        for (Onibus o : listaOnibus) {
            if (id.equals(o.getId())) {
                return o;
            }
        }
        return null;
    }
    
    /**
     * Cadastra o ônibus passado.
     * 
     * @param onibus Ônibus a ser cadastrado.
     */
    @Override
    public void adicionarOnibus(Onibus onibus) {
        listaOnibus.add(onibus);
    }

    @Override
    public void removerOnibus(Onibus onibus) {
        listaOnibus.remove(onibus);
    }

    @Override
    public void alterarOnibus(Onibus onibus, float novaKm) {
        
    }
    
    public List<Onibus> obterTodosOnibus() {
        return listaOnibus;
    }
}
