/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Ángel Dolz González
 */
public class AjustesView extends JFrame {
    private JLabel colorLabel;
    private JButton color1;
    private JButton color2;
    private JButton color3;
    private JButton color4;
    private JButton color5;
    private JLabel ratonLabel;
    private JButton raton1;
    private JButton raton2;
    private JButton raton3;
    private JButton reiniciar;
    private JButton atras;
   
    public AjustesView () {
        super ("Ajustes");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(false);
        this.setSize(720, 720);
        this.setLayout(null);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
        
        colorLabel = new JLabel ("SELECCION DE COLOR: ", JLabel.CENTER);
        colorLabel.setBounds (this.getWidth()/2 - 425, 125, 400, 50);
        colorLabel.setFont (new Font ("Arial", 1, 20));
        this.add (colorLabel);
            
        color1 = new JButton ();
        color1.setSize(10, 10);
        color1.setBackground(Color.DARK_GRAY);
        color1.setBounds(this.getWidth()/2 - 85, 125, 50, 50);
        color1.setActionCommand("Gris_Oscuro");
        this.add (color1);
        
        color2 = new JButton ();
        color2.setSize(10, 10);
        color2.setBackground(Color.BLACK);
        color2.setBounds(this.getWidth()/2 - 10, 125, 50, 50);
        color2.setActionCommand("Negro");
        this.add (color2);
        
        color3 = new JButton ();
        color3.setSize(10, 10);
        color3.setBackground(Color.RED);
        color3.setBounds(this.getWidth()/2 + 65, 125, 50, 50);
        color3.setActionCommand("Rojo");
        this.add (color3);
        
        color4 = new JButton ();
        color4.setSize(10, 10);
        color4.setBackground(Color.BLUE);
        color4.setBounds(this.getWidth()/2 + 140, 125, 50, 50);
        color4.setActionCommand("Azul");
        this.add (color4);
        
        color5 = new JButton ();
        color5.setSize(10, 10);
        color5.setBackground(Color.GREEN);
        color5.setBounds(this.getWidth()/2 + 215, 125, 50, 50);
        color5.setActionCommand("Verde");
        this.add (color5);
        
        ratonLabel = new JLabel ("SELECCION DE RATON: ", JLabel.CENTER);
        ratonLabel.setBounds (this.getWidth()/2 - 425, 225, 400, 50);
        ratonLabel.setFont (new Font ("Arial", 1, 20));
        this.add (ratonLabel);
        
        raton1 = new JButton ("Raton 1");
        raton1.setFont(new Font("Arial", 1, 15));
        raton1.setSize(10, 10);
        raton1.setBounds(this.getWidth()/2 - 85, 225, 89, 50);
        raton1.setActionCommand("Raton1");
        this.add (raton1);
        
        raton2 = new JButton ("Raton 2");
        raton2.setFont(new Font("Arial", 1, 15));
        raton2.setSize(10, 10);
        raton2.setBounds(this.getWidth()/2 + 45, 225, 89, 50);
        raton2.setActionCommand("Raton2");
        this.add (raton2);
        
        raton3 = new JButton ("Raton 3");
        raton3.setFont(new Font("Arial", 1, 15));
        raton3.setSize(10, 10);
        raton3.setBounds(this.getWidth()/2 + 175, 225, 89, 50);
        raton3.setActionCommand("Raton3");
        this.add (raton3);
        
        reiniciar = new JButton ("REINICIAR");
        reiniciar.setBounds(this.getWidth()/2 - 350/2, 420, 350, 55);
        reiniciar.setOpaque(true);
        reiniciar.setFont(new Font("Arial",1,28));
        reiniciar.setActionCommand("Reiniciar");
        this.add(reiniciar);
        
        atras = new JButton ("ATRAS");
        atras.setBounds(this.getWidth()/2 - 350/2, 500, 350, 75);
        atras.setOpaque(true);
        atras.setFont(new Font("Arial",1,28));
        atras.setActionCommand("Atras");
        this.add(atras);
    }
    
    public void setVisibleAjustes (boolean visible) {
        this.setVisible(visible);
    }
    
    public void setActionListener (ActionListener actionListener) {
        color1.addActionListener (actionListener);
        color2.addActionListener (actionListener);
        color3.addActionListener (actionListener);
        color4.addActionListener (actionListener);
        color5.addActionListener(actionListener);
        raton1.addActionListener (actionListener);
        raton2.addActionListener (actionListener);
        raton3.addActionListener (actionListener);
        reiniciar.addActionListener(actionListener);
        atras.addActionListener(actionListener);
    }
    
    public static void main(String[] argv) {
        AjustesView view = new AjustesView ();
        
        view.setVisible(true);
    }
}
