/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.Rasca_Y_Pica.Controller;

import es.uv.eu.Rasca_Y_Pica.View.AjustesView;
import es.uv.eu.Rasca_Y_Pica.View.FinalView;
import es.uv.eu.Rasca_Y_Pica.View.InicioView;
import es.uv.eu.Rasca_Y_Pica.View.JuegoView;
import es.uv.eu.Rasca_Y_Pica.Model.JuegoModel;
import es.uv.eu.Rasca_Y_Pica.View.AboutView;
import es.uv.eu.Rasca_Y_Pica.View.ErrorView;
import es.uv.eu.Rasca_Y_Pica.View.EstadisticasView;
import es.uv.eu.Rasca_Y_Pica.View.ReinicioView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Ángel Dolz González
 */
public class JuegoController {
    // Booleano de partida
    boolean comprobador;
    
    // View del juego
    private InicioView inicioView;
    private JuegoView juegoView;
    private FinalView finalView;
    private AjustesView ajustesView;
    private AboutView aboutView;
    private EstadisticasView estadView;
    private ErrorView errorView;
    private ReinicioView reinicioView;
    
    // Model del juego
    private JuegoModel juegoModel;
    
    public JuegoController (JuegoView juegoView, JuegoModel juegoModel, InicioView inicioView, AboutView aboutView, FinalView finalView, AjustesView ajustesView, EstadisticasView estadView, ErrorView errorView, ReinicioView reinicioView) {
        this.inicioView = inicioView;
        this.ajustesView = ajustesView;
        this.juegoView = juegoView;
        this.juegoModel = juegoModel;
        this.finalView = finalView;
        this.aboutView = aboutView;
        this.estadView = estadView;
        this.errorView = errorView;
        this.reinicioView = reinicioView;
        
        this.juegoView.setActionListener(new JuegoViewActionListener ());
        this.finalView.setActionListener(new FinalViewActionListener ());
        this.inicioView.setActionListener(new InicioViewActionListener ());
        this.ajustesView.setActionListener(new AjustesViewActionListener ());
        this.aboutView.setActionListener(new AboutViewActionListener ());
        this.errorView.setActionListener(new ErrorActionListener ());
        this.reinicioView.setActionListener(new ReincicioViewActionListener ());
    }
    
    class AjustesViewActionListener implements ActionListener {
              
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand();
           
            switch (command) {
                case "Gris_Oscuro":
                    juegoView.setColorCasillas(Color.DARK_GRAY);
                    break;
                case "Negro":
                   juegoView.setColorCasillas(Color.BLACK);
                   break;
                case "Rojo":
                   juegoView.setColorCasillas(Color.RED);
                   break;
                case "Azul":
                   juegoView.setColorCasillas(Color.BLUE);
                   break;
                case "Verde":
                    juegoView.setColorCasillas(Color.GREEN);
                    break;
                case "Raton1":
                    juegoView.setRaton(new ImageIcon ("imagenes/raton.png"));
                    System.out.println("Raton 1 seleccionado");
                    break;
                case "Raton2":
                    juegoView.setRaton(new ImageIcon ("imagenes/raton2.png"));
                    System.out.println("Raton 2 seleccionado");
                    break;
                case "Raton3":
                    juegoView.setRaton(new ImageIcon ("imagenes/raton3.png"));
                    System.out.println("Raton 3 seleccionado");
                    break;
                case "Reiniciar":
                    reinicioView.setVisibleReinicio(true);
                    break;
                case "Atras":
                    inicioView.setVisibleInicio(true);
                    ajustesView.setVisibleAjustes(false);
                    juegoView.inicializarCasillas();
                    break;
           }
       }
    }    
    
    class InicioViewActionListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand();
            
            switch (command) {
                case "Jugar":
                    if (inicioView.getNombre().equals("")) {
                        errorView.setVisibleError(true);
                    }
                    else if (!inicioView.getNombre().equals("")) {
                        juegoModel.StartGame();
                        juegoView.setVisible(true);
                        inicioView.setVisibleInicio(false);
                    }
                    break;
                case "Ajustes":
                    inicioView.setVisibleInicio(false);
                    ajustesView.setVisibleAjustes(true);
                    break;
                case "salir":
                    System.exit(0);
                    break;
                case "about":
                    aboutView.setVisible(true);
                    inicioView.setVisibleInicio(false);
                    break;
                case "Estadisticas":
                    estadView.setVisibleEstadisticas(true);
                    break;
            }
        }
    }
    
    class AboutViewActionListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand ();
                    
            switch (command) {
                case "Atras":
                    aboutView.setVisibleAbout (false);
                    inicioView.setVisibleInicio (true);
                    break;
            }
        }
    }
    
    class ErrorActionListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand ();
                    
            switch (command) {
                case "Atras":
                    errorView.setVisibleError (false);
                    inicioView.setVisibleInicio (true);
                    break;
            }
        }
    }
    
    class ReincicioViewActionListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand ();
                    
            switch (command) {
                case "atras":
                    reinicioView.setVisibleReinicio (false);
                    inicioView.setVisibleInicio (true);
                    System.out.println("Opcion atrás de reinicio pulsada");
                    break;
                case "aceptar":
                    reinicioView.setVisibleReinicio(false);
                    juegoView.setColorCasillas(Color.DARK_GRAY);
                    juegoView.setRaton(new ImageIcon ("imagenes/raton.png"));
                    estadView.reiniciarMejores();
                    System.out.println("Opcion aceptar de reinicio pulsada");
                    break;
            }
        }
    }
    
    class JuegoViewActionListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand ();
            System.out.println("COMANDO: " + command);
            
            if (!comprobador) {
                switch (command) {
                    case "0":
                        System.out.println("Presionando el boton: Casilla 1");
                        comprobador = juegoModel.comprobarGanador(0);
                        break;
                    case "1":
                        System.out.println("Presionando el boton: Casilla 2");
                        comprobador = juegoModel.comprobarGanador(1);
                        break;
                    case "2":
                        System.out.println("Presionando el boton: Casilla 3");
                        comprobador = juegoModel.comprobarGanador(2);
                        break;  
                    case "3":
                        System.out.println("Presionando el boton: Casilla 4");
                        comprobador = juegoModel.comprobarGanador(3);
                        break;
                    case "4":
                        System.out.println("Presionando el boton: Casilla 5");
                        comprobador = juegoModel.comprobarGanador(4);
                        break;
                    case "5":
                        System.out.println("Presionando el boton: Casilla 6");
                        comprobador = juegoModel.comprobarGanador(5);
                        break;
                    case "6":
                        System.out.println("Presionando el boton: Casilla 7");
                        comprobador = juegoModel.comprobarGanador(6);
                        break;
                    case "7":
                        System.out.println("Presionando el boton: Casilla 8");
                        comprobador = juegoModel.comprobarGanador(7);
                        break;  
                    case "8":
                        System.out.println("Presionando el boton: Casilla 9");
                        comprobador = juegoModel.comprobarGanador(8);
                        break;
                    case "9":
                        System.out.println("Presionando el boton: Casilla 10");
                        comprobador = juegoModel.comprobarGanador(9);
                        break;
                    case "10":
                        System.out.println("Presionando el boton: Casilla 11");
                        comprobador = juegoModel.comprobarGanador(10);
                        break;
                    case "11":
                        System.out.println("Presionando el boton: Casilla 12");
                        comprobador = juegoModel.comprobarGanador(11);
                        break;
                    case "12":
                        System.out.println("Presionando el boton: Casilla 13");
                        comprobador = juegoModel.comprobarGanador(12);
                        break;  
                    case "13":
                        System.out.println("Presionando el boton: Casilla 14");
                        comprobador = juegoModel.comprobarGanador(13);
                        break;
                    case "14":
                        System.out.println("Presionando el boton: Casilla 15");
                        comprobador = juegoModel.comprobarGanador(14);
                        break;
                    case "15":
                        System.out.println("Presionando el boton: Casilla 16");
                        comprobador = juegoModel.comprobarGanador(15);
                        break;
                    case "16":
                        System.out.println("Presionando el boton: Casilla 17");
                        comprobador = juegoModel.comprobarGanador(16);
                        break;
                    case "17":
                        System.out.println("Presionando el boton: Casilla 18");
                        comprobador = juegoModel.comprobarGanador(17);
                        break;  
                    case "18":
                        System.out.println("Presionando el boton: Casilla 19");
                        comprobador = juegoModel.comprobarGanador(18);
                        break;
                    case "19":
                        System.out.println("Presionando el boton: Casilla 20");
                        comprobador = juegoModel.comprobarGanador(19);
                        break;
                    case "20":
                        System.out.println("Presionando el boton: Casilla 21");
                        comprobador = juegoModel.comprobarGanador(20);
                        break;
                    case "21":
                        System.out.println("Presionando el boton: Casilla 22");
                        comprobador = juegoModel.comprobarGanador(21);
                        break;
                    case "22":
                        System.out.println("Presionando el boton: Casilla 23");
                        comprobador = juegoModel.comprobarGanador(22);
                        break;  
                    case "23":
                        System.out.println("Presionando el boton: Casilla 24");
                        comprobador = juegoModel.comprobarGanador(23);
                        break;
                    case "24":
                        System.out.println("Presionando el boton: Casilla 25");
                        comprobador = juegoModel.comprobarGanador(24);
                        break;
                }
            
            
                juegoView.setVolteadas(juegoModel.getVisible());
                juegoView.setPuntos(juegoModel.getPuntos());

                if (comprobador && juegoModel.getPuntos() >= 0) {
                    if (comprobador) {
                        //juegoModel.EndGame();
                        finalView.setVisible(true, true, juegoModel.getPuntos());
                        //juegoView.setVolteadas(juegoModel.EndGame());
                        //juegoView.inicializarCasillas();
                        //juegoModel.StartGame();
                        System.out.println("HAS GANADO");
                        estadView.setMejores(inicioView.getNombre(), juegoModel.getPuntos());
                        estadView.setVisibleEstadisticas(true);
                    }
                }

                if (juegoModel.getPuntos() <= 0) {
                    //juegoModel.EndGame();
                    finalView.setVisible(true, false, 0);
                    //juegoView.inicializarCasillas();
                    //juegoModel.StartGame();
                    System.out.println("HAS PERDIDO");
                    estadView.setMejores(inicioView.getNombre(), juegoModel.getPuntos());
                    estadView.setVisibleEstadisticas(true);
                    comprobador = true;
                }
            }
        }
    }
    
    class FinalViewActionListener implements ActionListener {
        
        @Override
        public void actionPerformed (ActionEvent ae) {
            String command = ae.getActionCommand();
            switch (command) {
                case "Aceptar":
                    juegoModel.EndGame();
                    juegoView.setPuntos(juegoModel.getPuntos());
                    juegoView.inicializarCasillas();
                    juegoView.setVisibleJuego(false);
                    finalView.setVisible(false, false, 0);
                    inicioView.setVisibleInicio(true);
                    estadView.setVisibleEstadisticas(false);
                    comprobador = false;
                    break;
                case "Rejugar":
                    juegoModel.EndGame();
                    juegoView.setPuntos(juegoModel.getPuntos());
                    juegoView.inicializarCasillas();
                    //juegoView.setVisibleJuego(false);
                    juegoModel.StartGame();
                    //juegoView.setVisibleJuego(true);
                    finalView.setVisible(false, false, 0);
                    estadView.setVisibleEstadisticas(false);
                    comprobador = false;
                    break;
            }
        }
    }
}
