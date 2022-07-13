/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Ángel Dolz González
 */
public class InicioView extends JFrame {
    private JButton jugar;
    private JButton ajustes;
    private JButton estadisticas;
    private JuegoMenuView juegoMenu;
    private JTextArea nombre;
    
    public InicioView () {
        super ("Pantalla de inicio");
        
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.setResizable (false);
        this.setBackground(Color.DARK_GRAY);
        
        this.setVisible (true);
        this.setSize(720, 720);
        this.setLayout(null);
        
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds(ancho/2 - this.getWidth()/2, alto/2 - this.getHeight()/2 - 50, this.getWidth(), this.getHeight());
    
        jugar = new JButton ("JUGAR");
        jugar.setBounds (this.getWidth() / 2 - 400/2, 170 - 120, 400, 125);
        jugar.setFont (new Font("Arial", 1, 48));
        jugar.setBackground (Color.LIGHT_GRAY);
        jugar.setActionCommand ("Jugar");
        jugar.setVisible(true);
        this.add (jugar);
        
        nombre = new JTextArea ("");
        nombre.setEditable(true);
        nombre.setBounds(this.getWidth() / 2 - 400/2, 190 , 400, 50);
        nombre.setFont (new Font("Arial", 1, 40));
        nombre.setBackground(Color.WHITE);
        nombre.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.WHITE));
        nombre.setVisible(true);
        this.add(nombre);
        
        ajustes = new JButton("AJUSTES");
        ajustes.setBounds(this.getWidth() / 2 - 400/2, 360 - 100, 400, 125);
        ajustes.setFont(new Font("Arial",1,48));
        ajustes.setBackground (Color.LIGHT_GRAY);
        ajustes.setActionCommand("Ajustes");
        ajustes.setVisible(true);
        this.add(ajustes);
        
        estadisticas = new JButton("ESTADISTICAS");
        estadisticas.setBounds(this.getWidth()/2 - 400/2, 550 - 80 , 400, 125);
        estadisticas.setFont(new Font("Arial",1,48));
        estadisticas.setBackground (Color.LIGHT_GRAY);
        estadisticas.setActionCommand("Estadisticas");
        estadisticas.setVisible(true);
        this.add(estadisticas);
        
        juegoMenu = new JuegoMenuView ();
        juegoMenu.setVisible(true);
        this.setJMenuBar(juegoMenu);
    }

    public String getNombre() {
        return nombre.getText();
    }
    
    public void setActionListener (ActionListener actionListener) {
        jugar.addActionListener(actionListener);
        ajustes.addActionListener(actionListener);
        estadisticas.addActionListener(actionListener);
        juegoMenu.setActionListener(actionListener);
    }
    
    public void setVisibleInicio (boolean visible) {
        this.setVisible(visible);
    }
    
    public static void main(String[] argv) {
        InicioView view = new InicioView ();
        
        view.setVisible(true);
    }
}
