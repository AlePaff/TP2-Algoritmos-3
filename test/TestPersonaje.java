package test;

import Modelo.excepciones.*;
import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORDENADA_EN_X_DE_INICIO = 8;
    protected static final int COORDENADA_EN_Y_DE_INICIO = 8;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO,COORDENADA_EN_Y_DE_INICIO, tablero);
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

        personaje.bajarLapiz();
        personaje.moverDerecha(tablero);
        Posicion posicionActual = personaje.getPosicion();

        assertTrue(tablero.getCasillero(posicionActual).estaPintado()) ;

    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = posicion.ALaDerecha(tablero);

        //Act
        personaje.moverDerecha(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }


    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = posicion.ALaIzquierda(tablero);

        //Act
        personaje.moverIzquierda(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = posicion.AArriba(tablero);

        //Act
        personaje.moverArriba(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = posicion.AAbajo(tablero);

        //Act
        personaje.moverAbajo(tablero);
        Posicion posicionActual = personaje.getPosicion();

        //Assert
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }


    @Test
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

        assertTrue(tablero.getCasillero(posicion).estaPintado());

        posicion = posicion.AAbajo(tablero);
        assertFalse(tablero.getCasillero(posicion).estaPintado());

        posicion = posicion.AAbajo(tablero);
        assertTrue(tablero.getCasillero(posicion).estaPintado());

        posicion = posicion.ALaDerecha(tablero);
        assertTrue(tablero.getCasillero(posicion).estaPintado());

        posicion = posicion.AArriba(tablero);
        assertFalse(tablero.getCasillero(posicion).estaPintado());

        posicion = posicion.AArriba(tablero);
        assertFalse(tablero.getCasillero(posicion).estaPintado());
    }

    /*@Test(expected = AldeanoEstaOcupadoException.class)
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