/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ángel Dolz González
 */
public class JuegoView extends JFrame {
    
    private JLabel puntosLabel;
    private Color color;
    private CasillasPanel casillasPanel;
    private List<JButton> casillas;
    private int[] casillasVisibles = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private int puntos;
    private ImageIcon raton;
    
    public JuegoView () {
        super ("Rasca Y Pica: Encuentra al ratón!");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        
        this.setVisible(false);
        this.setSize(720, 720);
        this.setLayout(new BorderLayout ());
        
        color = Color.DARK_GRAY;
        raton = new ImageIcon ("imagenes/raton.png");
        
        casillasPanel = new CasillasPanel ();
        casillasPanel.setBackground(Color.WHITE);
        this.add (casillasPanel, BorderLayout.CENTER);
        
        puntosLabel = new JLabel ();
        puntosLabel.setSize(100, 720);
        puntosLabel.setFont(new Font("Arial",1,20));
        puntosLabel.setOpaque(true);
        puntosLabel.setBackground(Color.DARK_GRAY);
        puntosLabel.setForeground(Color.WHITE);
        this.add(puntosLabel, BorderLayout.SOUTH); 
        
    }
    
    public class CasillasPanel extends JPanel {
        int j = 0;
        
        public CasillasPanel () {
            this.setLayout(new GridLayout(5, 5, 5, 5));
            casillas = new ArrayList <> (24);
            
            for (int i = 0; i < (5 * 5); i++) {
                JButton boton = new JButton ();
                boton.setSize (100, 100);
                if (casillasVisibles[i] == 1) {
                    boton.setBackground(color);
                    boton.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE));
                }
                
                casillas.add(boton);
            }
            
            for (JButton casilla : casillas) {
                casilla.setActionCommand(String.valueOf(j));
                this.add(casilla);
                j++;
            }
        }
    }
    
    public void setColorCasillas (Color color) {
        int j = 0;
        
        for (JButton casilla : casillas) {
            this.color = color;
            j++;
        }
    }
    
    public Color getColorCasilla () {
        return color;
    }
    
    public void setRaton (ImageIcon raton) {
        this.raton = raton;
    }
    
    public ImageIcon getRaton () {
        return raton;
    }
    
    public int[] inicializarCasillas () {
        int i = 0;
        
        for (JButton casilla : casillas) {
            casillasVisibles[i] = 1;
            casilla.setBackground(color);
            casilla.setIcon(null);
            casilla.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE));
            i++;
        }
        
        return casillasVisibles;
    }
    
    public void setVisibleJuego (boolean visible) {
        this.setVisible (visible);
    }
    
    public void setVolteadas (int [] i){
        casillasVisibles = i;
        int j = 0;
        
        for (JButton casilla : casillas) {
            // System.out.println ("Valor de la casilla " + j + " = " + casillasVisibles[j]);
            if (casillasVisibles[j] == 0) {
                casilla.setIcon(new ImageIcon ("imagenes/ratonera.jpg"));
            }
            else if (casillasVisibles[j] == 1){
                casilla.setBackground(color);
                casilla.setIcon(null);
                casilla.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE));
            }
            else if (casillasVisibles[j] == -1){
                casilla.setIcon(raton);
            }
                
            j++;
        }
    }
    
    public void setPuntos (int puntos) {
        this.puntos = puntos;
        this.puntosLabel.setText ("Te quedan: " + String.valueOf(puntos) + " Puntos");
    }
    
    public int getPuntos () {
        return puntos;
    }
    
    public static void main(String[] argv) {
        JuegoView view = new JuegoView ();
        
        view.setVisible(true);
    }
     
    public void setActionListener (ActionListener actionListener) {
        for (JButton casilla : casillas) {
            casilla.addActionListener(actionListener);
        }  
    }
}
