/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import com.mycompany.mapaia.grafo.Nodo;
import java.util.ArrayList;

/**
 *
 * @author mari2bar
 */
public class Dato {
    
    private int numero, pie, desgaste, carro, gasolina;
    private Pagina izquierda, derecha;
    private ArrayList<Nodo> nodo = new ArrayList<>();
    private String Tipo;
    
    public Dato(int numero){
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Pagina getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Pagina izquierda) {
        this.izquierda = izquierda;
    }

    public Pagina getDerecha() {
        return derecha;
    }

    public void setDerecha(Pagina derecha) {
        this.derecha = derecha;
    }

    public int getPie() {
        return pie;
    }

    public void setPie(int pie) {
        this.pie = pie;
    }

    public int getCarro() {
        return carro;
    }

    public void setCarro(int carro) {
        this.carro = carro;
    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }


    public int getDesgaste() {
        return desgaste;
    }

    public ArrayList<Nodo> getNodo() {
        return nodo;
    }

    public String getTipo() {
        return Tipo;
    }


    public void setDesgaste(int desgaste) {
        this.desgaste = desgaste;
    }

    public void setNodo(ArrayList<Nodo> nodo) {
        this.nodo = nodo;
    }

    public void setNumero() {
        switch(Tipo){
            case "carro":
                numero = carro;
                break;
            case "pie":
                numero = pie;
                break;
            case "desgaste":
                numero = desgaste;
                break;
            case "gasolina":
                numero = gasolina;
                break;
            default:
                numero = pie;
                break;
        }
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
}
