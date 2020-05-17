/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import com.mycompany.mapaia.grafo.Nodo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

/**
 *
 * @author mari2bar
 */
public class Pagina {

    protected Dato[] datos = new Dato[4];
    protected Pagina[] paginas = new Pagina[5];
    public static int numero = 0;
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
                    if (datos[i].getIzquierda() == null) {
                        cantidad++;
                        return this.posicionarDato(dato, i);
                    } else {
                        Dato p = datos[i].getIzquierda().ingresarDato(dato);
                        if (p != null) {
                            cantidad++;
                            return this.posicionarDato(p, i);
                        } else {
                            return null;
                        }
                    }
                } else if ((datos[i].getNumero() < dato.getNumero()) && (i == 3 || datos[i + 1] == null)) {
                    if (datos[i].getDerecha() == null) {
                        cantidad++;
                        return this.posicionarDato(dato, i + 1);
                    } else {
                        Dato p = datos[i].getDerecha().ingresarDato(dato);
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
            if (posicion - 1 >= 0 && nuevos[posicion - 1] != null && nuevos[posicion] != nuevos[posicion - 1]) {
                nuevos[posicion - 1].setDerecha(nuevos[posicion].getIzquierda());
            }
            if (posicion + 1 <= 4 && nuevos[posicion + 1] != null && nuevos[posicion] != nuevos[posicion + 1]) {
                nuevos[posicion + 1].setIzquierda(nuevos[posicion].getDerecha());
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
        Pagina izquierda = new Pagina(Pagina.numero);
        izquierda.getDatos()[0] = datos[0];
        izquierda.getDatos()[1] = datos[1];
        izquierda.getPaginas()[0] = datos[0].getIzquierda();
        izquierda.getPaginas()[1] = datos[0].getDerecha();
        izquierda.getPaginas()[2] = datos[1].getDerecha();
        izquierda.setEntero(2);
        Pagina.numero += 1;
        Pagina derecha = new Pagina(Pagina.numero);
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

    public Dato buscarPrimero() {
        if (datos[0] != null && datos[0].getIzquierda() != null) {
            return datos[0].getIzquierda().buscarPrimero();
        } else if (datos[0] == null) {
            return null;
        } else {
            return datos[0];
        }
    }

    public void ingresarDato(JPanel tree, Integer pos) {
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                if (datos[i].getIzquierda() != null) {
                    datos[i].getIzquierda().ingresarDato(tree, pos);
                }
                datos[i].setLocation(0, pos * 50);
                datos[i].setBackground(Color.black);
                datos[i].setForeground(Color.WHITE);
                datos[i].setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 14));
                datos[i].setOpaque(true);
                String ruta ="";
                for (Nodo nodo : datos[i].getNodo()) {
                    ruta+= nodo.getNombre()+"-";
                }
                if (datos[i].getNodo().size() >= 2) {
                    datos[i].setText("   " + ".-   " + ruta + "--" + datos[i].getNumero());
                } else {
                    datos[i].setText("  .-   Ha Llegado!!");
                }
                tree.add(datos[i]);
                pos += 1;
                if (datos[i] != null && datos[i].getDerecha() != null && (i + 1 >= 4 || datos[i + 1] == null)) {
                    datos[i].getDerecha().ingresarDato(tree, pos);
                }
            }
        }
        tree.setBackground(Color.white);
    }

    public String exportar() {
        int[] contador = new int[6];
        contador[0] = ArbolB.contador;
        String s = "node" + ArbolB.contador + "[label = \"" + escribirNodos() + " \"];\n";
        int j = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null && datos[i].getIzquierda() != null) {
                ArbolB.sumarContador();
                contador[i + 1] = ArbolB.contador;
                s += datos[i].getIzquierda().exportar();
                j++;
                if (i + 1 >= 4 || datos[i + 1] == null) {
                    ArbolB.sumarContador();
                    contador[i + 2] = ArbolB.contador;
                    s += datos[i].getDerecha().exportar();
                    j++;
                }
            }
        }
        s += escribirFlechas(contador);
        return s;
    }

    public String escribirNodos() {
        String s = "";
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                s += "<f" + i * 2 + "> |";
                String ruta ="";
                for (Nodo nodo : datos[i].getNodo()) {
                    ruta+= nodo.getNombre()+"-";
                }
                if(datos[i].getNodo().size()>=2){
                s += "<f" + ((i * 2) + 1) + "> " + ruta + datos[i].getNumero() + "|";
                }else{
                    s += "<f" + ((i * 2) + 1) + "> Ha llegado |";
                }
                if (i + 1 >= 4 || datos[i + 1] == null) {
                    s += "<f" + ((i * 2) + 2) + ">";
                }
            }
        }
        return s;
    }

    public String escribirFlechas(int[] num) {
        String s = "";
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null && datos[i].getIzquierda() != null) {
                s += "\"node" + num[0] + "\":f" + (i * 2) + " -> \"node" + num[i + 1] + "\":f" + (datos[i].getIzquierda().getCantidad()) + ";\n";
                if (i + 1 >= 4 || datos[i + 1] == null) {
                    s += "\"node" + num[0] + "\":f" + ((i * 2) + 2) + " -> \"node" + num[i + 2] + "\":f" + (datos[i].getDerecha().getCantidad()) + ";\n";
                }
            }
        }
        return s;
    }

    public int getCantidad() {
        int d = 0;
        for (Dato dato : datos) {
            if (dato != null) {
                d++;
            }
        }
        return d;
    }

}
