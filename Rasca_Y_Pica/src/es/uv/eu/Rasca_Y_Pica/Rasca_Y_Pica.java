/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica;

import es.uv.eu.Rasca_Y_Pica.View.AjustesView;
import es.uv.eu.Rasca_Y_Pica.View.JuegoView;
import es.uv.eu.Rasca_Y_Pica.View.FinalView;
import es.uv.eu.Rasca_Y_Pica.View.InicioView;
import es.uv.eu.Rasca_Y_Pica.Model.*;
import es.uv.eu.Rasca_Y_Pica.Controller.*;
import es.uv.eu.Rasca_Y_Pica.View.AboutView;
import es.uv.eu.Rasca_Y_Pica.View.ErrorView;
import es.uv.eu.Rasca_Y_Pica.View.EstadisticasView;
import es.uv.eu.Rasca_Y_Pica.View.ReinicioView;

/**
 *¡
 * @author Ángel Dolz Gonzalez
 */
public class Rasca_Y_Pica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JuegoModel juegoModel = new JuegoModel ();
        InicioView inicioView = new InicioView ();
        AjustesView ajustesView = new AjustesView ();
        JuegoView juegoView = new JuegoView ();
        FinalView finalView = new FinalView ();
        AboutView aboutView = new AboutView ();
        EstadisticasView estadView = new EstadisticasView ();
        ErrorView errorView = new ErrorView ();
        ReinicioView reinicioView = new ReinicioView ();
         
        JuegoController juegoController = new JuegoController (juegoView, juegoModel, inicioView, aboutView, finalView, ajustesView, estadView, errorView, reinicioView);
    }
    
}
