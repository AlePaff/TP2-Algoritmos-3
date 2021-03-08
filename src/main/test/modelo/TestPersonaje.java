package modelo;

import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORDENADA_X_INICIO = 50;
    protected static final int COORDENADA_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE, ALTURA);
    public Posicion posicionInicial = new Posicion(COORDENADA_X_INICIO,COORDENADA_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicionInicial);
    protected final int RANGO_DE_MOVIMIENTO = personaje.RANGO_DE_MOVIMIENTO;

    @Test
    public void testPersonajeSeCreaConLapizArriba(){

        personaje.moverArriba(tablero);

        assertFalse(tablero.estaPintado(personaje.getPosicion()));
    }

    @Test
    public void testPersonajeDibujaTodasLasPosicionesIntermedias(){

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for (int i = 1; i <= RANGO_DE_MOVIMIENTO; i++) {
            posiciones.add(new Posicion(COORDENADA_X_INICIO, COORDENADA_Y_INICIO - i, tablero));
        }
        personaje.bajarLapiz();
        personaje.moverArriba(tablero);

        assertEquals(tablero.getPosicionesDibujadas(), posiciones) ;
    }

    @Test
    public void testPersonajeSeMueveADerecha(){
        //A
        Posicion posicionFinal = new Posicion(COORDENADA_X_INICIO + RANGO_DE_MOVIMIENTO, COORDENADA_Y_INICIO, tablero);

        //Act
        personaje.moverDerecha(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }


    @Test
    public void testPersonajeSeMueveAIzquierda(){
        //A
        Posicion posicionFinal = new Posicion(COORDENADA_X_INICIO - RANGO_DE_MOVIMIENTO, COORDENADA_Y_INICIO, tablero);

        //Act
        personaje.moverIzquierda(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));

    }

    @Test
    public void testPersonajeSeMueveArriba(){
        //A
        Posicion posicionFinal = new Posicion(COORDENADA_X_INICIO, COORDENADA_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        //Act
        personaje.moverArriba(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testPersonajeSeMueveAbajo(){
        //A
        Posicion posicionFinal = new Posicion(COORDENADA_X_INICIO, COORDENADA_Y_INICIO + RANGO_DE_MOVIMIENTO, tablero);

        //Act
        personaje.moverAbajo(tablero);

        //Assert
        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testCrearAlPersonajeConCoordenadaNegativaLanzaUnaExcepcion(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    new Personaje( new Posicion(-1,5, tablero));
                });
    }

    @Test
    public void testCrearAlPersonajeEnCoordenadaLimiteLanzaUnaExcepcion(){

        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    new Personaje( new Posicion(15,ALTURA, tablero));
                });
    }

    @Test
    public void testMoverAlPersonajeFueraDeRangoLanzaUnaExcepcion(){
        Personaje personajeTest = new Personaje( new Posicion(0,COORDENADA_Y_INICIO, tablero));

        assertThrows(PosicionFueraDeRangoException.class,
                ()-> personajeTest.moverIzquierda(tablero));

    }

    @Test
    public void testCuandoSeSaleDelTableroNoDibuja(){
        Posicion posicion = new Posicion(0,COORDENADA_Y_INICIO, tablero);
        Personaje personajeTest = new Personaje(posicion);
        personaje.bajarLapiz();
        try{
            personajeTest.moverIzquierda(tablero);
        } catch (PosicionFueraDeRangoException e){
            assertFalse(tablero.estaPintado(posicion));
        }
    }
}