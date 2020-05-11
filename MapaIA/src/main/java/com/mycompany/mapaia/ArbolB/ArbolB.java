/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 *
 * @author mari2bar
 */
public class ArbolB {

    private Pagina raiz = new Pagina(1);
    private int datos = 0;

    public void ingresarDato(int numero) {
        Dato dato = raiz.ingresarDato(new Dato(numero));
        if (dato != null) {
            raiz = new Pagina(1);
            raiz.ingresarDato(dato);
        }
    }

    public void ingresarDato(Dato nuevo) {
        datos++;
        Dato dato = raiz.ingresarDato(nuevo);
        if (dato != null) {
            raiz = new Pagina(1);
            raiz.ingresarDato(dato);
        }
    }

    public Integer buscarDato(int numero) {
        return raiz.buscarDato(numero);
    }

    public Dato buscarPrimero(){
        return raiz.buscarPrimero();
    }
    
    public void ingresarArbol(JPanel tree){
        tree.setPreferredSize(new Dimension(282, 0));
        raiz.ingresarDato(tree);
    }
    
    public int getDatos() {
        return datos;
    }

}
