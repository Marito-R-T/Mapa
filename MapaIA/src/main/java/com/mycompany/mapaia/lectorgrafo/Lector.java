/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.lectorgrafo;

import com.mycompany.mapaia.grafo.Arista;
import com.mycompany.mapaia.grafo.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author mari2bar
 */
public class Lector {

    public Grafo leerArchivo() {
        JFileChooser filechooser = new JFileChooser("/home/mari2bar/Documentos/pruebas/Estructura/");
        File file = null;
        if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = filechooser.getSelectedFile();
            try {
                BufferedReader bf = new BufferedReader(new FileReader(file));
                String s;
                Grafo grafo = new Grafo();
                while ((s = bf.readLine()) != null) {
                    Arista nuevo = new Arista(s);
                    grafo.ingresarNodo(nuevo);
                }
                return grafo;
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        return null;
    }

}
