package test;

import Modelo.excepciones.*;
import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    public Tablero tablero = new Tablero(15,15);
    public Posicion posicion = new Posicion(8,8, tablero);
    public Personaje personaje = new Personaje(posicion);


    @Test
    public void TestPersonajeSeCreaConLapizArriba(){
    //Dijo que con una prueba de que no se dibuje bastaba
        personaje.moverDerecha(tablero);
        Posicion posicionActual = personaje.getPosicion();

        assertFalse(tablero.getCasillero(posicionActual).estaPintado());

    }

    @Test
    public void TestPersonajeBajaElLapiz(){
    //lo mismo que la anterior, con verificar que dibuje bastaría

        personaje.bajarLapiz();
        personaje.moverDerecha(tablero);
        Posicion posicionActual = personaje.getPosicion();

        assertTrue(tablero.getCasillero(posicionActual).estaPintado()) ;

    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = new Posicion(9,8, tablero);

        //Act
        personaje.moverDerecha(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }


    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = new Posicion(7,8, tablero);

        //Act
        personaje.moverIzquierda(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = new Posicion(8,9, tablero);

        //Act
        personaje.moverArriba(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = new Posicion(8,7, tablero);

        //Act
        personaje.moverAbajo(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }


    /*@Test
    public void PersonajeSeMueveConLapizArribaYAbajoYDibujaCorrectamente(){
        personaje.moverAbajo(tablero);
        personaje.bajarLapiz();
        personaje.moverAbajo(tablero);
        personaje.moverDerecha(tablero);
        personaje.subirLapiz();
        personaje.moverArriba(tablero);
        personaje.moverArriba(tablero);
        personaje.bajarLapiz();
        personaje.moverIzquierda(tablero);


        assertFalse(tablero.getCasillero(8,7).estaPintado());
        assertTrue(tablero.getCasillero(8,6).estaPintado());
        assertTrue(tablero.getCasillero(9,6).estaPintado());
        assertFalse(tablero.getCasillero(9,7).estaPintado());
        assertFalse(tablero.getCasillero(9,8).estaPintado());
        assertTrue(tablero.getCasillero(8,8).estaPintado());

    }

    @Test(expected = AldeanoEstaOcupadoException.class)
    //PosicionFueraDeRangoException
    public void TestCrearAlPersonajeFueraDeRangoLanzaUnaExcepcion(){
        Personaje personajeTest = new Personaje( new Posicion(-1,5, tablero));
    }

    @Test(expected = PosicionFueraDeRangoException.class)
    //PosicionFueraDeRangoException
    public void TestMoverAlPersonajeFueraDeRangoLanzaUnaExcepcion(){
        Personaje personajeTest = new Personaje( new Posicion(14,14, tablero));
        personaje.moverDerecha(tablero);
    }*/
}