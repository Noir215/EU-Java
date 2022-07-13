/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.Model;

import java.util.Random;

/**
 *
 * @author Ángel Dolz González
 */
public class JuegoModel {
    private boolean inicio = false;
    
    // Seteo de las casillas
    private int[] casillasVisibles = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private int inicioPuntos = 24;      // Igual al numero de casillas -1
    private int raton = -1;
    
    public JuegoModel () {}
    
    public void setRaton () {
        Random num = new Random ();
        raton = num.nextInt(24);        // Cambiar la linea cuando puedan settearse las casillas
        System.out.println ("El ratón está en: " + raton);     // Consola para saber quien es el raton
    }
    
    public void StartGame () {
        inicio = true;
        setRaton ();
    }
    
    public int [] EndGame () {
        inicioPuntos = 24;
        
        for (int i = 0; i < 24; i++) {
            casillasVisibles[i] = 1;
            //System.out.println("Reinicio casilla " + i + " = " + casillasVisibles[i]);
        }
        
        inicio = false;
        raton = -1;
        
        return casillasVisibles;
    }
    
    public boolean TodoListo () {
        return inicio;
    }
    
    public int getPuntos () {
        return inicioPuntos;
    }
    
    public int[] getVisible () {
        return casillasVisibles;
    }
    
    public boolean comprobarGanador (int i) {
        System.out.println("Comprobando ganador...");
        
        if (i != raton && casillasVisibles[i] != 0) {
            inicioPuntos--;
            casillasVisibles[i] = 0;
        }
        else if (i == raton) {
            casillasVisibles[i] = -1;
        }
        
        System.out.println("Valor ratón " + raton);
        return i == raton;
    }
}
