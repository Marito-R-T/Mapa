/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.frame;

import com.mycompany.mapaia.ArbolB.ArbolB;
import com.mycompany.mapaia.frame.diseño.Iconos;
import com.mycompany.mapaia.grafo.Arista;
import com.mycompany.mapaia.grafo.Grafo;
import com.mycompany.mapaia.grafo.Nodo;
import com.mycompany.mapaia.lectorgrafo.Lector;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author mari2bar
 */
public class MapaFrame extends javax.swing.JFrame {

    /**
     * Creates new form MapaFrame
     */
    private Grafo grafo;

    public MapaFrame() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        initComponents();
        ImageIcon i = new ImageIcon(getClass().getResource("/a.png"));
        Image ima = i.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        this.setIconImage(i.getImage());
        this.setLocationRelativeTo(null);
        Iconos icon = new Iconos();
        icon.ingresarIconos(tabbedArbolB);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        spGrafo = new javax.swing.JScrollPane();
        pnlGrafo = new javax.swing.JPanel();
        tabbedArbolB = new javax.swing.JTabbedPane();
        comboCaminar = new javax.swing.JComboBox<>();
        txtDestino = new javax.swing.JTextField();
        btnPosibilidades = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnGrafo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemLeer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlGrafo.setBackground(new java.awt.Color(193, 174, 188));
        pnlGrafo.setPreferredSize(new java.awt.Dimension(990, 945));

        javax.swing.GroupLayout pnlGrafoLayout = new javax.swing.GroupLayout(pnlGrafo);
        pnlGrafo.setLayout(pnlGrafoLayout);
        pnlGrafoLayout.setHorizontalGroup(
            pnlGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 997, Short.MAX_VALUE)
        );
        pnlGrafoLayout.setVerticalGroup(
            pnlGrafoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );

        spGrafo.setViewportView(pnlGrafo);

        tabbedArbolB.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        comboCaminar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCaminarItemStateChanged(evt);
            }
        });

        btnPosibilidades.setText("Buscar Posibilidades");
        btnPosibilidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosibilidadesActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar ArbolB");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnGrafo.setText("Exportar Grafo");
        btnGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabbedArbolB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCaminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addComponent(btnGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPosibilidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportar))
                    .addComponent(txtDestino, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                    .addGroup(pnlFondoLayout.createSequentialGroup()
                        .addComponent(tabbedArbolB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExportar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(btnPosibilidades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jMenu1.setText("Options");

        itemLeer.setText("Leer Archivo");
        itemLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLeerActionPerformed(evt);
            }
        });
        jMenu1.add(itemLeer);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLeerActionPerformed
        // TODO add your handling code here:
        Lector lector = new Lector();
        grafo = lector.leerArchivo();
        //grafo.grafico();
        spGrafo.setViewportView(grafo);
        spGrafo.repaint();
        hacerImagen();

    }//GEN-LAST:event_itemLeerActionPerformed

    public void hacerImagen() {
        BufferedImage bfi = new BufferedImage(990, 945, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bfi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(193, 174, 188));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        grafo.desmarcarNodos();
        grafo.dibujarNodos(g2);
        grafo.desmarcarAristas();
        grafo.desmarcarNodos();
        g2.dispose();
        File file = new File("/home/mari2bar/Documentos/Proyectos/Estructura de Datos/Mapa/MapaIA/src/main/resources/Grafo/grafo.png");
        file.delete();
        try {
            ImageIO.write(bfi, "png", file);
            this.posibilidades();
            this.posicionarSiguientes();
                //Thread.sleep(2000);
            grafo.ingresarLabel(file);
            //spGrafo.setViewportView(grafo);
            //spGrafo.repaint();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void btnPosibilidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosibilidadesActionPerformed
        // TODO add your handling code here:
        this.posibilidades();
    }//GEN-LAST:event_btnPosibilidadesActionPerformed

    public void posibilidades(){
        switch (tabbedArbolB.getSelectedIndex()) {
            case 0:
                ingresarPosibilidadesPie();
                break;
            case 1:
                ingresarPosibilidadesCarro();
                break;
            case 2:
                ingresarPosibilidadesGasolina();
                break;
            case 3:
                ingresarPosibilidadesDesgaste();
                break;
        }
    }
    
    private void comboCaminarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCaminarItemStateChanged
        // TODO add your handling code here:
        int i = comboCaminar.getSelectedIndex();
        if (i > 0) {
            grafo.setPosicionado(grafo.buscarNodo(new Nodo(comboCaminar.getItemAt(i))));
            this.hacerImagen();
            comboCaminar.setSelectedIndex(0);
        }
    }//GEN-LAST:event_comboCaminarItemStateChanged

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // TODO add your handling code here:
        ArbolB b = grafo.caminosNodo(grafo.getPosicionado(), new Nodo(txtDestino.getText()), tabbedArbolB.getToolTipTextAt(tabbedArbolB.getSelectedIndex()));
        b.exportar();
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafoActionPerformed
        // TODO add your handling code here:
        grafo.grafico();
    }//GEN-LAST:event_btnGrafoActionPerformed

    public void posicionarSiguientes() {
        comboCaminar.removeAllItems();
        comboCaminar.addItem("Siguientes");
        for (Arista arista : grafo.getPosicionado().getAristas()) {
            if (!arista.getDestino().equals(grafo.getPosicionado())) {
                comboCaminar.addItem(arista.getDestino().toString());
            } else if (!arista.getInicio().equals(grafo.getPosicionado())) {
                comboCaminar.addItem(arista.getInicio().toString());
            }
        }
    }

    public void ingresarPosibilidadesPie() {
        ArbolB b = grafo.caminosNodo(grafo.getPosicionado(), new Nodo(txtDestino.getText()), "pie");
        grafo.desmarcarNodos();
        if (b != null) {
            JPanel nuevo = new JPanel();
            JScrollPane sp = new JScrollPane();
            b.ingresarArbol(nuevo);
            sp.setViewportView(nuevo);
            sp.setPreferredSize(new Dimension(282, 390));
            tabbedArbolB.setComponentAt(0, sp);
        }
    }
    
    public void ingresarPosibilidadesGasolina(){
        ArbolB b = grafo.caminosNodo(grafo.getPosicionado(), new Nodo(txtDestino.getText()), "gasolina");
        if (b != null) {
            JPanel nuevo = new JPanel();
            JScrollPane sp = new JScrollPane();
            b.ingresarArbol(nuevo);
            sp.setViewportView(nuevo);
            sp.setPreferredSize(new Dimension(282, 390));
            tabbedArbolB.setComponentAt(2, sp);
        }
    }
    
    public void ingresarPosibilidadesDesgaste(){
        ArbolB b = grafo.caminosNodo(grafo.getPosicionado(), new Nodo(txtDestino.getText()), "desgaste");
        if (b != null) {
            JPanel nuevo = new JPanel();
            JScrollPane sp = new JScrollPane();
            b.ingresarArbol(nuevo);
            sp.setViewportView(nuevo);
            sp.setPreferredSize(new Dimension(282, 390));
            tabbedArbolB.setComponentAt(3, sp);
        }
    }

    public void ingresarPosibilidadesCarro() {
        ArbolB b = grafo.caminosNodo(grafo.getPosicionado(), new Nodo(txtDestino.getText()), "carro");
        if (b != null) {
            JPanel nuevo = new JPanel();
            JScrollPane sp = new JScrollPane();
            b.ingresarArbol(nuevo);
            sp.setViewportView(nuevo);
            sp.setPreferredSize(new Dimension(282, 390));
            tabbedArbolB.setComponentAt(1, sp);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnGrafo;
    private javax.swing.JButton btnPosibilidades;
    private javax.swing.JComboBox<String> comboCaminar;
    private javax.swing.JMenuItem itemLeer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlGrafo;
    private javax.swing.JScrollPane spGrafo;
    private javax.swing.JTabbedPane tabbedArbolB;
    private javax.swing.JTextField txtDestino;
    // End of variables declaration//GEN-END:variables
}
