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

    public Tablero tablero = new Tablero(BASE, ALTURA);
    public Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO,COORDENADA_EN_Y_DE_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);


    @Test
    public void TestPersonajeSeCreaConLapizArriba(){

        personaje.moverArriba(tablero);

        Posicion posicionFinal = posicion.haciaArriba(tablero);

        assertFalse(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void TestPersonajeBajaElLapiz(){

        personaje.bajarLapiz();
        personaje.moverArriba(tablero);

        Posicion posicionFinal = posicion.haciaArriba(tablero);

        assertTrue(tablero.estaPintado(posicionFinal)) ;

    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = posicion.aDerecha(tablero);

        //Act
        personaje.moverDerecha(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }


    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = posicion.aIzquierda(tablero);

        //Act
        personaje.moverIzquierda(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = posicion.haciaArriba(tablero);

        //Act
        personaje.moverArriba(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = posicion.haciaAbajo(tablero);

        //Act
        personaje.moverAbajo(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
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

        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.haciaAbajo(tablero);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.haciaAbajo(tablero);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.aDerecha(tablero);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.haciaArriba(tablero);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.haciaArriba(tablero);
        assertFalse(tablero.estaPintado(posicion));
    }

    /*@Test(expected = FrulaException.class)
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