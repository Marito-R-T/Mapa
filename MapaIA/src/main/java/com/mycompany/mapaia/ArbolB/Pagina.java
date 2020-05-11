/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

/**
 *
 * @author mari2bar
 */
public class Pagina {

    protected Dato[] datos = new Dato[4];
    protected Pagina[] paginas = new Pagina[5];
    private int no;
    private int cantidad;

    public Pagina(int no) {
        this.no = no;
        this.cantidad = 0;
    }

    public int getNo() {
        return no;
    }

    public Integer buscarDato(int dato) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i].getNumero() == dato) {
                return datos[i].getNumero();
            } else if (datos[i].getNumero() > dato) {
                if (paginas[i] == null) {
                    return null;
                } else {
                    return paginas[i].buscarDato(dato);
                }
            } else if ((datos[i].getNumero() < dato) && (i == 3 || datos[i + 1] == null)) {
                if (paginas[i + 1] == null) {
                    return null;
                } else {
                    return paginas[i + 1].buscarDato(dato);
                }
            }
        }
        return null;
    }

    public Dato ingresarDato(Dato dato) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                if (datos[i].getNumero() >= dato.getNumero()) {
                    if (paginas[i] == null) {
                        cantidad++;
                        return this.posicionarDato(dato, i);
                    } else {
                        Dato p = paginas[i].ingresarDato(dato);
                        if (p != null) {
                            cantidad++;
                            return this.posicionarDato(p, i);
                        } else {
                            return null;
                        }
                    }
                } else if ((datos[i].getNumero() < dato.getNumero()) && (i == 3 || datos[i + 1] == null)) {
                    if (paginas[i + 1] == null) {
                        cantidad++;
                        return this.posicionarDato(dato, i + 1);
                    } else {
                        Dato p = paginas[i + 1].ingresarDato(dato);
                        if (p != null) {
                            cantidad++;
                            return this.posicionarDato(p, i + 1);
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                cantidad++;
                datos[i] = dato;
                paginas[i] = dato.getIzquierda();
                paginas[i + 1] = dato.getDerecha();
                return null;
            }
        }
        return null;
    }

    public Dato posicionarDato(Dato dato, int posicion) {
        if (cantidad == 5) {
            Dato[] nuevos = new Dato[5];
            for (int i = 0; i < posicion; i++) {
                nuevos[i] = this.datos[i];
            }
            nuevos[posicion] = dato;
            for (int i = posicion + 1; i < 5; i++) {
                nuevos[i] = this.datos[i - 1];
            }
            return crearPagina(nuevos);
        } else {
            if (posicion != 4) {
                if (this.datos[posicion] != null) {
                    this.posicionarDato(this.datos[posicion], posicion + 1);
                }
                this.datos[posicion] = dato;
                if (posicion - 1 >= 0 && this.datos[posicion - 1] != null && this.datos[posicion] != this.datos[posicion - 1]) {
                    this.datos[posicion - 1].setDerecha(this.datos[posicion].getIzquierda());
                }
                if (posicion + 1 <= 3 && this.datos[posicion + 1] != null && this.datos[posicion] != this.datos[posicion + 1]) {
                    this.datos[posicion + 1].setIzquierda(this.datos[posicion].getDerecha());
                }
                this.paginas[posicion] = this.datos[posicion].getIzquierda();
                this.paginas[posicion + 1] = this.datos[posicion].getDerecha();
                return null;
            } else {
                return null;
            }
        }

    }

    public Dato crearPagina(Dato datos[]) {
        Dato padre = datos[2];
        Pagina izquierda = new Pagina(1);
        izquierda.getDatos()[0] = datos[0];
        izquierda.getDatos()[1] = datos[1];
        izquierda.getPaginas()[0] = datos[0].getIzquierda();
        izquierda.getPaginas()[1] = datos[0].getDerecha();
        izquierda.getPaginas()[2] = datos[1].getDerecha();
        izquierda.setEntero(2);
        Pagina derecha = new Pagina(2);
        derecha.getDatos()[0] = datos[3];
        derecha.getDatos()[1] = datos[4];
        derecha.getPaginas()[0] = datos[3].getIzquierda();
        derecha.getPaginas()[1] = datos[3].getDerecha();
        derecha.getPaginas()[2] = datos[4].getDerecha();
        derecha.setEntero(2);
        padre.setDerecha(derecha);
        padre.setIzquierda(izquierda);
        return padre;
    }

    public void setEntero(int cantidad) {
        this.cantidad = cantidad;
    }

    public Dato[] getDatos() {
        return datos;
    }

    public Pagina[] getPaginas() {
        return paginas;
    }

    public void setPagina(int no, Pagina nueva) {
        this.paginas[no] = nueva;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    public Dato buscarPrimero(){
        if(datos[0]!=null && datos[0].getIzquierda()!=null){
            return datos[0].getIzquierda().buscarPrimero();
        } else if(datos[0]==null){
            return null;
        } else{
            return datos[0];
        }
    }
    
    public void ingresarDato(JPanel tree){
        for (int i = 0; i < datos.length; i++) {  
            if(datos[i]!=null){
                datos[i].getIzquierda().ingresarDato(tree);
                JLabel label = new JLabel();
                label.setSize(282, 50);
                label.setLocation(0, tree.getHeight());
                tree.setPreferredSize(new Dimension(282, tree.getHeight()+50));
                if(datos[i+1]==null){
                    datos[i].getDerecha().ingresarDato(tree);
                }
            }
        }
    }

}
