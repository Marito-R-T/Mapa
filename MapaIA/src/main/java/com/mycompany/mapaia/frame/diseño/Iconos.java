/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.frame.diseño;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author mari2bar
 */
public class Iconos {
    
    public void ingresarIconos(JTabbedPane tabbed){
        ImageIcon i1 = new ImageIcon(getClass().getResource("/tipos/pie.png"));
        Image ima1 = i1.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(getClass().getResource("/tipos/carro.png"));
        Image ima2 = i2.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(getClass().getResource("/tipos/gasolina.png"));
        Image ima3 = i3.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(getClass().getResource("/tipos/desgaste.png"));
        Image ima4 = i4.getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT);
        JScrollPane sp1 = new JScrollPane(),sp2 = new JScrollPane(), sp3 = new JScrollPane(), sp4 = new JScrollPane();
        JPanel panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel(), panel4 = new JPanel();
        sp1.setViewportView(panel1);
        sp2.setViewportView(panel2);
        sp3.setViewportView(panel3);
        sp3.setViewportView(panel4);
        tabbed.addTab("", new ImageIcon(ima1), sp1, "Pie");
        tabbed.addTab("", new ImageIcon(ima2), sp2, "Carro");
        tabbed.addTab("", new ImageIcon(ima3), sp3, "Gasolina");
        tabbed.addTab("", new ImageIcon(ima4), sp4, "Desgaste");
    }
    
}
