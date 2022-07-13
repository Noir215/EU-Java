/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Ángel Dolz González
 */
public class ReinicioView extends JFrame {
    private JTextArea texto;
    private JButton atras;
    private JButton aceptar;
    
    public ReinicioView() {
        super ("Mensaje de reinicio");
        
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setResizable (false);
        
        this.setVisible (false);
        this.setSize (500, 300);
        this.setLayout (null);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
        
        texto = new JTextArea("¿Estás seguro de que quieres \n      reiniciar las opciones?");
        texto.setAlignmentX(CENTER_ALIGNMENT);
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setFont(new Font("Arial",1,20));
        texto.setBounds(this.getWidth()/2 - 160, this.getHeight()/2 - 100, 650, 100);
        this.add(texto);
        
        atras = new JButton("ATRÁS");
        atras.setBounds(this.getWidth()/2 - 160, this.getHeight()/2, 150, 50);
        atras.setOpaque(true);
        atras.setFont(new Font("Arial",1,20));
        atras.setActionCommand("atras");
        this.add(atras);
        
        aceptar = new JButton("ACEPTAR");
        aceptar.setBounds(this.getWidth()/2, this.getHeight()/2, 150, 50);
        aceptar.setOpaque(true);
        aceptar.setFont(new Font("Arial",1,20));
        aceptar.setActionCommand("aceptar");
        this.add(aceptar);
    }
    
    public void setActionListener(ActionListener actionListener ) {
        atras.addActionListener(actionListener);
        aceptar.addActionListener(actionListener);
    }
    
    public void setVisibleReinicio(boolean visible) {
        this.setVisible(visible);
    }
    
    public static void main(String[] argv) {
        ReinicioView view = new ReinicioView ();
        
        view.setVisible(true);
    }
}
