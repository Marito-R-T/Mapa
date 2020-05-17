/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import com.mycompany.mapaia.grafo.Grafo;
import com.mycompany.mapaia.grafo.Nodo;
import com.mycompany.mapaia.lectorgrafo.Lector;

/**
 *
 * @author mari2bar
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Lector lector = new Lector();
        Grafo grafo = lector.leerArchivo();
        if (grafo != null) {
            ArbolB b = grafo.caminosNodo(new Nodo("Quetzaltenango"), new Nodo("Xela"), "pie");
        }
        /*ArbolB b = new ArbolB();
        b.ingresarDato(10);
        b.ingresarDato(1);
        b.ingresarDato(5);
        b.ingresarDato(8);
        b.ingresarDato(15);
        b.ingresarDato(14);
        b.ingresarDato(87);
        b.ingresarDato(89);
        b.ingresarDato(100);
        b.ingresarDato(12);
        b.ingresarDato(2);
        b.ingresarDato(45);
        b.ingresarDato(55);
        b.ingresarDato(65);
        b.ingresarDato(44);
        System.out.println(b.buscarDato(10));
        System.out.println(b.buscarDato(8));
        System.out.println(b.buscarDato(15));
        System.out.println(b.buscarDato(14));
        System.out.println(b.buscarDato(87));
        System.out.println(b.buscarDato(55));
        System.out.println(b.buscarDato(65));
        System.out.println(b.buscarDato(44));*/
    }

}
