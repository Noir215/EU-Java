/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.View;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Noir2
 */
public class JuegoMenuView extends JMenuBar {
    private JMenu opciones;
    private JMenuItem salir;
    private JMenuItem about;
    
    public JuegoMenuView () {
        opciones = new JMenu ("Opciones");
        salir = new JMenuItem ("Salir");
        about = new JMenuItem ("Acerca de...");
        
        salir.setActionCommand("salir");
        about.setActionCommand("about");
        
        opciones.add(salir);
        opciones.add(about);
        this.add(opciones);
    }
    
    public void setActionListener (ActionListener actionListener) {
        salir.addActionListener(actionListener);
        about.addActionListener(actionListener);
    }
}
