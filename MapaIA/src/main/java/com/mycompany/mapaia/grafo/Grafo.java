/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.grafo;

import com.mycompany.mapaia.ArbolB.ArbolB;
import com.mycompany.mapaia.ArbolB.Dato;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mari2bar
 */
public class Grafo extends JPanel {

    private Nodo posicionado;

    public Grafo() {
        this.setBackground(new Color(193, 174, 188));
        this.setPreferredSize(new Dimension(550, 500));
        this.setLocation(0, 0);
    }

    public void ingresarNodo(Arista a) {
        if (posicionado != null) {
            Nodo i = buscarNodo(posicionado, a.getInicio());
            this.desmarcarNodos();
            Nodo f = buscarNodo(posicionado, a.getDestino());
            this.desmarcarNodos();
            if (i != null && f != null) {
                a.setInicio(i);
                a.setDestino(f);
            } else if (i != null) {
                a.setInicio(i);
                a.getDestino().setPosicion(i, (a.getTiempopie() % 25 + 10) * 3);
            } else if (f != null) {
                a.setDestino(f);
                a.getInicio().setPosicion(f, (a.getTiempopie() % 25 + 10) * 3);
            }
            a.getInicio().getAristas().add(a);
            a.getInicio().getFlechas().add(a);
            a.getDestino().getAristas().add(a);
        } else {
            posicionado = a.getInicio();
            posicionado.getFlechas().add(a);
            posicionado.getAristas().add(a);
            a.getDestino().getAristas().add(a);
            posicionado.x = 250;
            posicionado.y = 300;
            a.getDestino().setPosicion(posicionado, (a.getTiempopie() % 25 + 10) * 3);
        }
    }

    public Nodo buscarNodo(Nodo actual, Nodo nodo) {
        if (actual.getNombre().equals(nodo.getNombre())) {
            return actual;
        } else {
            for (Arista arista : actual.getAristas()) {
                if (arista.getDestino() != actual && !arista.getDestino().isMarcado()) {
                    arista.getDestino().setMarcado(true);
                    Nodo n = buscarNodo(arista.getDestino(), nodo);
                    if (n != null) {
                        return n;
                    }
                } else if (arista.getInicio() != actual && !arista.getInicio().isMarcado()) {
                    arista.getInicio().setMarcado(true);
                    Nodo n = buscarNodo(arista.getInicio(), nodo);
                    if (n != null) {
                        return n;
                    }
                }
            }
            return null;
        }
    }

    public Nodo buscarNodo(Nodo nodo) {
        Nodo n = buscarNodo(posicionado, nodo);
        this.desmarcarNodos();
        return n;
    }

    public ArbolB caminosNodo(Nodo inicio, Nodo destino, String tipo) {
        Nodo i = this.buscarNodo(posicionado, inicio);
        this.desmarcarNodos();
        Nodo d = this.buscarNodo(posicionado, destino);
        this.desmarcarNodos();
        if (i != null && d != null) {
            ArbolB arbol = new ArbolB();
            i.moverse(d, this, new Dato(0), arbol, tipo);
            return arbol;
        } else {
            return null;
        }
    }

    public boolean desmarcarNodos() {
        posicionado.desmarcarCercanos();
        return true;
    }

    public boolean desmarcarAristas() {
        posicionado.desmarcarAristas(null);
        return true;
    }

    public Nodo getPosicionado() {
        return posicionado;
    }

    public void dibujarNodos(Graphics g) {
        posicionado.dibujar(g, null);
    }

    public void dibujarNodos(Graphics2D g) {
        posicionado.dibujar(g, null);
    }

    /*@Override
    public void paintComponent(Graphics g) {
        this.dibujarNodos(g);
        this.desmarcarAristas();
    }*/
    public void grafico() {
        File file = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/Grafo/grafo.dot");
        if (!file.exists()) {
            try {
                System.out.println(file.getPath());
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        try {
            String string = "digraph G {\n"
                    + posicionado.graficar(null)
                    + "}";
            this.desmarcarAristas();
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                pw.write(string);
                System.out.println(string);
                pw.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        try {
            File file2 = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/Grafo/grafo.png");
            if (file2.exists()) {
                if (file2.delete()) {
                    System.out.println("");
                }
            }
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/Grafo/grafo.png",
                    "/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/target/classes/Grafo/grafo.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/Grafo/grafo.png"));
        Image image = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        System.out.println(image.toString());
        JLabel label = new JLabel();
        label.setLocation(10, 10);
        label.setPreferredSize(new Dimension(500, 500));
        label.setMinimumSize(new Dimension(500, 500));
        label.setIcon(new ImageIcon(image));
        this.add(label);
    }

    public void ingresarLabel() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/Grafo/grafo.png"));
        Image image = icon.getImage().getScaledInstance(550, 500, Image.SCALE_SMOOTH);
        System.out.println(image.toString());
        JLabel label = new JLabel();
        label.setLocation(0, 0);
        label.setPreferredSize(new Dimension(550, 550));
        label.setMinimumSize(new Dimension(550, 550));
        label.setIcon(new ImageIcon(image));
        this.add(label);
    }

}
