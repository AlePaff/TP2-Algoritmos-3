package modelo;

import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORDENADA_EN_X_DE_INICIO = 8;
    protected static final int COORDENADA_EN_Y_DE_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1; //personaje.getDISTANCIAMOVIMIENTO()

    public Tablero tablero = new Tablero(BASE, ALTURA);
    public Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO,COORDENADA_EN_Y_DE_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);


    @Test
    public void testPersonajeSeCreaConLapizArriba(){

        personaje.moverArriba(tablero);

        Posicion posicionFinal = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);

        assertFalse(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void testPersonajeBajaElLapiz(){

        personaje.bajarLapiz();
        personaje.moverArriba(tablero);

        Posicion posicionFinal = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);

        assertTrue(tablero.estaPintado(posicionFinal)) ;

    }

    @Test
    public void testPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);

        //Act
        personaje.moverDerecha(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }


    @Test
    public void testPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = posicion.moverIzquierda(tablero, DISTANCIA_DE_MOVIMIENTO);

        //Act
        personaje.moverIzquierda(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));

    }

    @Test
    public void testPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);

        //Act
        personaje.moverArriba(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO);

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

        posicion = posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);
        assertTrue(tablero.estaPintado(posicion));

        posicion = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);
        assertFalse(tablero.estaPintado(posicion));

        posicion = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);
        assertFalse(tablero.estaPintado(posicion));
    }

    @Test
    public void testCrearAlPersonajeFueraDeRangoLanzaUnaExcepcion(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Personaje personajeTest = new Personaje( new Posicion(-1,5, tablero));
                    personajeTest.moverDerecha(tablero);
                });
    }

    @Test
    public void testCrearAlPersonajeFueraDeRangoLanzaUnaExcepcionParteDos(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Personaje personajeTest = new Personaje( new Posicion(15,15, tablero));
                    personajeTest.moverDerecha(tablero);
                });
    }

    @Test
    public void testMoverAlPersonajeFueraDeRangoLanzaUnaExcepcion(){
        Personaje personajeTest = new Personaje( new Posicion(14,14, tablero));

        assertThrows(PosicionFueraDeRangoException.class,
                ()-> personajeTest.moverDerecha(tablero));

    }

    @Test
    public void testCuandoSeSaleDelRangoNoDibuja(){
        Posicion posicion = new Posicion(14,14, tablero);
        Personaje personajeTest = new Personaje(posicion);
        personaje.bajarLapiz();
        try{
            personajeTest.moverDerecha(tablero);
        } catch (PosicionFueraDeRangoException e){
            assertFalse(tablero.estaPintado(posicion));
        }

    }

}