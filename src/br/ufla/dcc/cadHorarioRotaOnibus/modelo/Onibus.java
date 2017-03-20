/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.cadHorarioRotaOnibus.modelo;

/**
 *
 * @author group
 */
public class Onibus {
    //Identificação do ônibus
    private String id;
    //Marca do ônibus
    private String marca;
    //Modelo do ônibus
    private String modelo;
    //Ano de fabricação do ônibus
    private int ano;
    //Quilometragem rodada do ônibus
    private float km;  
    //Quantidade de pessoas que o ônibus pode transportar
    private int capacidade;
    
    /**
     * Constroi um ônibus a partir do id, marca, modelo, ano, quilometragem e capacidade.
     * 
     * @param id Identificação do ônibus.
     * @param marca Marca do ônibus.
     * @param modelo Modelo do ônibus.
     * @param ano Ano de fabricação do ônibus.
     * @param km Quilometragem rodada do ônibus.
     * @param capacidade Quantidade de pessoas que o ônibus pode transportar.
     */
    public Onibus(String id, String marca, String modelo, int ano, float km, int capacidade){
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.km = (float)km;
        this.capacidade = capacidade;
    }

    /**
     * 
     * @return Retorna o ID do ônibus.
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @return Retorna a marca do ônibus.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * 
     * @return Retorna o modelo do ônibus
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * 
     * @return Retorna o ano de fabricação do ônibus.
     */
    public int getAno() {
        return ano;
    }

    /**
     * 
     * @return Retorna a quilometragem atual do ônibus.
     */
    public float getKm() {
        return km;
    }

    /**
     * 
     * @return Retorna a quantidade de pessoas que o ônibus pode transportar.
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * 
     * @param km Altera a quilometragem do ônibus (após uma viagem)
     */
    public void setKm(float km) {
        this.km = km;
    }
    
    /**
     * 
     * @param marca Altera a marca do ônibus 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * 
     * @param modelo Altera o modelo do ônibus 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * 
     * @param ano Altera o ano de fabricação do ônibus 
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    /**
     * 
     * @param capacidade Altera o ano de fabricação do ônibus 
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}