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
public class FinalView extends JFrame {
    private JLabel resultado;
    private JLabel puntuacion;
    private JButton aceptar;
    private JButton rejugar;
    private int puntos;
    
    public FinalView () {
        super("Resultado");
        
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        
        this.setVisible(false);
        this.setSize(720, 640);
        this.setLayout(null);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
    
        resultado = new JLabel("");
        resultado.setFont(new Font("Arial", 1, 80));
        resultado.setAlignmentY(0.5f);
        resultado.setBounds(720/2 - 550/2, 640/2 - 520/2 - 50, 600, 520);
        
        puntuacion = new JLabel ("");
        puntuacion.setBounds(720/2 - 490/2, 640/2 - 400/2 - 50, 600, 520);
        puntuacion.setFont(new Font("Arial", 1, 30));
        
        aceptar = new JButton ("ACEPTAR");
        aceptar.setBounds(this.getWidth()/2 - 340, 500, 320, 75);
        aceptar.setFont (new Font("Arial", 1, 30));
        aceptar.setBackground(Color.DARK_GRAY);
        aceptar.setForeground(Color.WHITE);
        aceptar.setActionCommand("Aceptar");
        this.add (aceptar);
        
        rejugar = new JButton ("REJUGAR");
        rejugar.setBounds(this.getWidth()/2 , 500, 320, 75);
        rejugar.setFont (new Font("Arial", 1, 30));
        rejugar.setBackground(Color.DARK_GRAY);
        rejugar.setForeground(Color.WHITE);
        rejugar.setActionCommand("Rejugar");
        this.add (rejugar);
    }
    
    public void setVisible (boolean visible, boolean victoria, int puntos) {
        this.setVisible(visible);
        this.puntos = puntos;
        
        if (victoria) {
            resultado.setText("HAS GANADO");  
            puntuacion.setText ("Tu puntuacion ha sido: " + puntos + " puntos");
            this.add(resultado);
            this.add(puntuacion);
        }
        else {
            resultado.setText("HAS PERDIDO");
            this.add(resultado);
        }
    }
    
    public void setActionListener (ActionListener actionListener) {
        aceptar.addActionListener(actionListener);
        rejugar.addActionListener(actionListener);
    }
    
    public static void main(String[] argv) {
        FinalView view = new FinalView ();
        
        view.setVisible(true, true, 30);
    }
}
