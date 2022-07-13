/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ángel Dolz González
 */
public class EstadisticasView extends JFrame {
    private List <JLabel> mejores;
    private List <JLabel> puntuaciones;
    private int [] puntuacion = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String [] nombres = {"", "", "", "", "", "", "", "", "", ""};
    String mejor;
    
    public EstadisticasView () {
        super("Estadisticas");
        
        mejores = new ArrayList <> ();
        mejor = "";
        int incremento = 60;
        
        this.setLayout(null);
        this.setSize(400, 800);
        this.setVisible(false);
        this.setResizable(false);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
        
        JLabel stats = new JLabel ("ESTADISTICAS");
        stats.setFont(new Font ("Arial", 1, 40));
        stats.setBounds(this.getWidth()/2 - 150, 50, 350, 75);
        this.add (stats);
        
        for (int i = 0; i < 10; i++) {
            JLabel jugador = new JLabel ();
                  
            jugador.setFont (new Font ("Arial", 1, 20));
            jugador.setBackground(Color.RED);
            jugador.setBounds(this.getWidth()/2 - 120, 100 + (incremento * i) , 350, 75);
            mejores.add(jugador);
        }
        
        for (JLabel jugador : mejores) {
            this.add (jugador);
        }
    }
    
    public void setMejores (String mejor, int puntos) {
        int aux;
        int i = 0;
        
        String nomAux = "";
        
        for (JLabel jugador : mejores) {
            // System.out.println ("Valor de la casilla " + j + " = " + casillasVisibles[j]);
            if (puntuacion[i] < puntos) {
                aux = puntuacion[i];
                puntuacion[i] = puntos;
                puntos = aux;
                nomAux = nombres[i];
                nombres[i] = mejor;
                mejor = nomAux;
                jugador.setText((i + 1) + "             " + nombres[i] + "              " + puntuacion[i]);
            }
            i++;
        }
    }
    
    public void reiniciarMejores () {
        int i = 0;
        for (JLabel jugador : mejores) {
            jugador.setText("");
            puntuacion[i] = 0;
            nombres[i] = "";
            i++;
        }
    }
    
    public void setVisibleEstadisticas (boolean visible) {
        this.setVisible(visible);
    }

    public List<JLabel> getMejores() {
        return mejores;
    }

    public int[] getPuntuacion() {
        return puntuacion;
    }
    
    
    
    public static void main(String[] argv) {
        EstadisticasView view = new EstadisticasView ();
        
        view.setVisible(true);
    }
}