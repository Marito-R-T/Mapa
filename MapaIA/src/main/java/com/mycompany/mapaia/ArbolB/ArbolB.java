/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.ArbolB;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author mari2bar
 */
public class ArbolB {

    private Pagina raiz = new Pagina(Pagina.numero);
    private int datos = 0;
    public static Integer contador = 0;

    public static void resetContador(){
        contador = 0;
    }
    
    public static void sumarContador(){
        ArbolB.contador = ArbolB.contador + 1;
    }
    
    public void ingresarDato(int numero) {
        Dato dato = raiz.ingresarDato(new Dato(numero));
        if (dato != null) {
            Pagina.numero += 1;
            raiz = new Pagina(Pagina.numero);
            raiz.ingresarDato(dato);
        }
    }

    public void ingresarDato(Dato nuevo) {
        datos++;
        Dato dato = raiz.ingresarDato(nuevo);
        if (dato != null) {
            Pagina.numero += 1;
            raiz = new Pagina(Pagina.numero);
            raiz.ingresarDato(dato);
        }
    }

    public Integer buscarDato(int numero) {
        return raiz.buscarDato(numero);
    }

    public Dato buscarPrimero() {
        return raiz.buscarPrimero();
    }

    public void ingresarArbol(JPanel tree) {
        tree.setSize(282, 56 * datos);
        tree.setPreferredSize(new Dimension(450, 56 * this.datos));
        Integer o = 0;
        raiz.ingresarDato(tree, o);
    }

    public int getDatos() {
        return datos;
    }

    public void exportar() {
        ArbolB.resetContador();
        String s = "digraph g {\n"
                + "node [shape = record,height=.1];\n"
                + raiz.exportar()
                + "}";
        File file = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/ArbolB/arbol.dot");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        try {
            try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
                pw.write(s);
                pw.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        File file2 = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/ArbolB/arbol.png");
        try {
            if (file2.exists()) {
                if (file2.delete()) {
                }
            }
            ProcessBuilder pbuilder;

            /*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/ArbolB/arbol.png",
                    "/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/ArbolB/arbol.dot");
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
            Thread.sleep(2000);
            file2 = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/ArbolB/arbol.png");
            Desktop.getDesktop().open(file2);
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }

}
