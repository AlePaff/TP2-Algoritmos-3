package test;

import Modelo.excepciones.PosicionFueraDeRangoException;
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

        Posicion posicionFinal = posicion.moverArriba(tablero);

        assertFalse(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void TestPersonajeBajaElLapiz(){

        personaje.bajarLapiz();
        personaje.moverArriba(tablero);

        Posicion posicionFinal = posicion.moverArriba(tablero);

        assertTrue(tablero.estaPintado(posicionFinal)) ;

    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = posicion.moverDerecha(tablero);

        //Act
        personaje.moverDerecha(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }


    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = posicion.moverIzquierda(tablero);

        //Act
        personaje.moverIzquierda(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = posicion.moverArriba(tablero);

        //Act
        personaje.moverArriba(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = posicion.moverAbajo(tablero);

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

        posicion = posicion.moverAbajo(tablero);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.moverAbajo(tablero);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.moverDerecha(tablero);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.moverArriba(tablero);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.moverArriba(tablero);
        assertFalse(tablero.estaPintado(posicion));
    }

    @Test
    public void TestCrearAlPersonajeFueraDeRangoLanzaUnaExcepcion(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Personaje personajeTest = new Personaje( new Posicion(-1,5, tablero));
                    personajeTest.moverDerecha(tablero);
                });
    }

    @Test
    public void TestCrearAlPersonajeFueraDeRangoLanzaUnaExcepcionParteDos(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Personaje personajeTest = new Personaje( new Posicion(15,15, tablero));
                    personajeTest.moverDerecha(tablero);
                });
    }

    @Test
    public void TestMoverAlPersonajeFueraDeRangoLanzaUnaExcepcion(){
        Personaje personajeTest = new Personaje( new Posicion(14,14, tablero));

        assertThrows(PosicionFueraDeRangoException.class,
                ()-> personajeTest.moverDerecha(tablero));

    }

    @Test
    public void TestCuandoSeSaleDelRangoNoDibuja(){
        Posicion posicion = new Posicion(14,14, tablero);
        Personaje personajeTest = new Personaje(posicion);
        personaje.bajarLapiz();
        try{
            personajeTest.moverDerecha(tablero);
        } catch (PosicionFueraDeRangoException e){
            assertFalse(tablero.estaPintado(posicion));
        }

    }

    /*@Test
    public void TestParaAtraparExcepciones(){
        Personaje personajeTest = new Personaje( new Posicion(14,14, tablero));

        try{
            personajeTest.moverDerecha(tablero);
        } catch (PosicionFueraDeRangoException e){
            assertEquals(personajeTest.getPosicion().getPosX(),14);
        }

    }

    @Test
    public void TestParaAtraparExcepciones2(){
        Personaje personajeTest = new Personaje( new Posicion(14,14, tablero));

        try{
            personajeTest.moverArriba(tablero);
        } catch (PosicionFueraDeRangoException e){
            assertEquals(personajeTest.getPosicion().getPosY(),14);
        }

    }*/
}