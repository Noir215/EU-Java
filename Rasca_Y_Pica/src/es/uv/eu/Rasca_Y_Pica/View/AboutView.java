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
public class AboutView extends JFrame {
    private JTextArea texto;
    private JButton atras;
    
    public AboutView () {
        super ("Sobre la aplicacion");
        
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setResizable (false);
        
        this.setVisible (false);
        this.setSize (500, 500);
        this.setLayout (null);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
        
        texto = new JTextArea("Esta aplicacion ha sido desarrollada en su \ntotalidad por: \n \n \n" +
                              "   - Ángel Dolz González");
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setFont(new Font("Arial",1,20));
        texto.setBounds(this.getWidth()/2 - 220, this.getHeight()/2 - 400/2, 650, 300);
        this.add(texto);
        
        atras = new JButton("ATRAS");
        atras.setBounds(this.getWidth()/2 - 160, this.getHeight()/2 + 50, 300, 100);
        atras.setOpaque(true);
        atras.setFont(new Font("Arial",1,28));
        atras.setActionCommand("Atras");
        this.add(atras);
    }
    
    public void setActionListener(ActionListener actionListener ) {
        atras.addActionListener(actionListener);
    }
    
    public void setVisibleAbout(boolean visible) {
        this.setVisible(visible);
    }
    
    public static void main(String[] argv) {
        AboutView view = new AboutView ();
        
        view.setVisible(true);
    }
}
