/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.grafo;

/**
 *
 * @author mari2bar
 */
public class Arista {
    
    private Integer gasolina, desgaste;
    private Integer tiempopie, tiempocarro;
    private Nodo destino, inicio;
    private boolean marcada = false;
    
    public Arista(String s){
        String[] atributos;
        atributos = s.split("\\|");
        inicio = new Nodo(atributos[0]);
        destino = new Nodo(atributos[1]);
        tiempocarro = Integer.parseInt(atributos[2]);
        tiempopie = Integer.parseInt(atributos[3]);
        gasolina = Integer.parseInt(atributos[4]);
        desgaste = Integer.parseInt(atributos[5]);
    }
    
    public Nodo getDestino() {
        return destino;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Integer getGasolina() {
        return gasolina;
    }

    public Integer getDesgaste() {
        return desgaste;
    }

    public Integer getTiempopie() {
        return tiempopie;
    }

    public Integer getTiempocarro() {
        return tiempocarro;
    }

    public boolean isMarcada() {
        return marcada;
    }

    public void setMarcada(boolean marcada) {
        this.marcada = marcada;
    }
    
}
