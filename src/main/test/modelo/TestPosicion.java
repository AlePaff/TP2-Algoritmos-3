package modelo;

import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPosicion {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORDENADA_X_INICIO = 8;
    protected static final int COORDENADA_Y_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;
    protected static final int COORDENADA_FUERA_DE_RANGO = 15;
    protected static final int COORDENADA_BORDE = 14;

    public Tablero tablero = new Tablero(BASE, ALTURA);
    public Posicion posicion = new Posicion(COORDENADA_X_INICIO,COORDENADA_Y_INICIO, tablero);

    @Test
    public void testPosicionSeMueveParaArriba(){
        Posicion posicionFinal =  new Posicion(COORDENADA_X_INICIO, COORDENADA_Y_INICIO - DISTANCIA_DE_MOVIMIENTO, tablero);

        posicion = posicion.moverArriba(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void testPosicionSeMueveParaAbajo(){
        Posicion posicionFinal =  new Posicion(COORDENADA_X_INICIO, COORDENADA_Y_INICIO + DISTANCIA_DE_MOVIMIENTO, tablero);

        posicion = posicion.moverAbajo(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void testPosicionSeMueveParaLaIzquierda(){
        Posicion posicionFinal =  new Posicion(COORDENADA_X_INICIO - DISTANCIA_DE_MOVIMIENTO, COORDENADA_Y_INICIO, tablero);

        posicion = posicion.moverIzquierda(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void testPosicionSeMueveParaLaDerecha(){
        Posicion posicionFinal =  new Posicion(COORDENADA_X_INICIO + DISTANCIA_DE_MOVIMIENTO, COORDENADA_Y_INICIO, tablero);

        posicion = posicion.moverDerecha(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void testCrearLaPosicionFueraDeRangoLanzaUnaExcepcion(){
        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Posicion posicion = new Posicion(COORDENADA_FUERA_DE_RANGO,COORDENADA_FUERA_DE_RANGO, tablero);
                    posicion.moverAbajo(tablero);
                });
    }

    @Test
    public void testMoverLaPosicionFueraDeRangoLanzaUnaExcepcion(){

        Posicion posicion = new Posicion(COORDENADA_BORDE,COORDENADA_BORDE, tablero);

        assertThrows(PosicionFueraDeRangoException.class,
                ()-> posicion.moverDerecha(tablero));

    }

}
