/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapaia.grafo;

import com.mycompany.mapaia.ArbolB.ArbolB;
import com.mycompany.mapaia.ArbolB.Dato;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mari2bar
 */
public class Nodo {

    private ArrayList<Arista> aristas = new ArrayList<>();
    private ArrayList<Arista> flechas = new ArrayList<>();
    public int x, y;
    private String nombre;
    private int id;
    private boolean marcado = false;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(Nodo ref, int pie) {
        Random random = new Random();
        int x1 = random.nextInt(pie) + 1;
        int i = (random.nextInt(x1) + 1) * 2;
        Double f = Math.sqrt((pie * pie) - ((x1 - i) * (x1 - i)));
        x = ref.x + (x1 - i);
        if (random.nextInt(2) == 0) {
            y = ref.y + f.intValue();
        } else {
            y = ref.y - f.intValue();
        }

    }

    public Arista ingresarArista(Arista arista, int entero) {
        if (entero < aristas.size()) {
            if (arista.getDestino().getNombre().equals(aristas.get(entero).getDestino().getNombre())) {
                arista.setDestino(aristas.get(entero).getDestino());
                aristas.add(arista);
            } else {
                if (!arista.getDestino().marcado) {
                    arista.getDestino().ingresarArista(arista, 0);
                } else {
                    this.ingresarArista(arista, entero + 1);
                }
            }
        } else {
            return null;
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public ArrayList<Arista> getFlechas() {
        return flechas;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public void desmarcarCercanos() {
        this.marcado = false;
        for (Arista arista : aristas) {
            if (!arista.getDestino().equals(this) && arista.getDestino().isMarcado()) {
                arista.getDestino().desmarcarCercanos();
            } else if (!arista.getInicio().equals(this) && arista.getInicio().isMarcado()) {
                arista.getInicio().desmarcarCercanos();
            }
        }
    }

    public void desmarcarAristas(Arista a) {
        if (a != null) {
            a.setMarcada(false);
        }
        for (Arista arista : aristas) {
            if (!arista.getDestino().equals(this) && arista.isMarcada()) {
                arista.getDestino().desmarcarAristas(arista);
            } else if (!arista.getInicio().equals(this) && arista.isMarcada()) {
                arista.getInicio().desmarcarAristas(arista);
            }
        }
    }

    public void moverse(Nodo f, Grafo grafo, Dato d, ArbolB b, String tipo) {
        d.getNodo().add(this);
        if (!this.equals(f)) {
            this.marcado = true;
            for (Arista arista1 : aristas) {
                if (!arista1.getDestino().equals(this) && !arista1.getDestino().isMarcado()) {
                    d.setCarro(d.getCarro() + arista1.getTiempocarro());
                    d.setPie(d.getPie() + arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() + arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() + arista1.getDesgaste());
                    arista1.getDestino().moverse(f, grafo, d, b, tipo);
                    d.setCarro(d.getCarro() - arista1.getTiempocarro());
                    d.setPie(d.getPie() - arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() - arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() - arista1.getDesgaste());
                } else if (!arista1.getInicio().equals(this) && !arista1.getInicio().isMarcado()) {
                    d.setCarro(d.getCarro() + arista1.getTiempocarro());
                    d.setPie(d.getPie() + arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() + arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() + arista1.getDesgaste());
                    arista1.getInicio().moverse(f, grafo, d, b, tipo);
                    d.setCarro(d.getCarro() - arista1.getTiempocarro());
                    d.setPie(d.getPie() - arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() - arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() - arista1.getDesgaste());
                }
            }
            this.marcado = false;
        } else {
            Dato e = new Dato(d.getNumero() + 1);
            e.getNodo().addAll(d.getNodo());
            e.setPie(d.getPie());
            e.setCarro(d.getCarro());
            e.setGasolina(d.getGasolina());
            e.setDesgaste(d.getDesgaste());
            e.setTipo(tipo);
            e.setNumero();
            //agregar dato a Arbol
            b.ingresarDato(e);
            //////////////////////
        }
        d.getNodo().remove(d.getNodo().size() - 1);
    }

    public void moversef(Nodo f, Grafo grafo, Dato d, ArbolB b, String tipo) {
        d.getNodo().add(this);
        if (!this.equals(f)) {
            this.marcado = true;
            for (Arista arista1 : flechas) {
                if (!arista1.getDestino().isMarcado()) {
                    d.setCarro(d.getCarro() + arista1.getTiempocarro());
                    d.setPie(d.getPie() + arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() + arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() + arista1.getDesgaste());
                    arista1.getDestino().moversef(f, grafo, d, b, tipo);
                    d.setCarro(d.getCarro() - arista1.getTiempocarro());
                    d.setPie(d.getPie() - arista1.getTiempopie());
                    d.setGasolina(d.getGasolina() - arista1.getGasolina());
                    d.setDesgaste(d.getDesgaste() - arista1.getDesgaste());
                }
            }
            this.marcado = false;
        } else {
            Dato e = new Dato(d.getNumero() + 1);
            e.getNodo().addAll(d.getNodo());
            e.setPie(d.getPie());
            e.setCarro(d.getCarro());
            e.setGasolina(d.getGasolina());
            e.setDesgaste(d.getDesgaste());
            e.setTipo(tipo);
            e.setNumero();
            //agregar dato a Arbol
            b.ingresarDato(e);
            //////////////////////
        }
        d.getNodo().remove(d.getNodo().size() - 1);
    }

    public void dibujar(Graphics g, Arista a) {
        if (a != null) {
            a.setMarcada(true);
            g.setColor(new Color(133, 99, 96));
            g.drawLine(a.getInicio().x + 5, a.getInicio().y + 5, a.getDestino().x + 5, a.getDestino().y + 5);
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.RED);
        }
        if (!this.marcado) {
            g.drawOval(this.x, this.y, 10, 10);
            g.fillOval(this.x, this.y, 10, 10);
            g.setColor(Color.BLACK);
            g.drawString(nombre, this.x - (nombre.length()), this.y - 1);
        }
        this.setMarcado(true);
        for (Arista arista : aristas) {
            if (!arista.getDestino().equals(this) && !arista.isMarcada()) {
                arista.getDestino().dibujar(g, arista);
            } else if (!arista.getInicio().equals(this) && !arista.isMarcada()) {
                arista.getInicio().dibujar(g, arista);
            }
        }
    }

    public String graficar(Arista a) {
        String s = "";
        if (a != null) {
            s = a.getInicio().getNombre().replaceAll(" ", "_") + " -> " + a.getDestino().getNombre().replaceAll(" ", "_") + ";\n";
            a.setMarcada(true);
        }
        for (Arista arista : aristas) {
            if (!arista.getDestino().equals(this) && !arista.isMarcada()) {
                s += arista.getDestino().graficar(arista);
            } else if (!arista.getInicio().equals(this) && !arista.isMarcada()) {
                s += arista.getInicio().graficar(arista);
            }
        }
        return s;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
