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
    protected static final int COORDENADA_EN_X_DE_INICIO = 8;
    protected static final int COORDENADA_EN_Y_DE_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;
    protected static final int COORDENADA_FUERA_DE_RANGO = 15;
    protected static final int COORDENADA_BORDE = 14;


    public Tablero tablero = new Tablero(BASE, ALTURA);
    public Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO,COORDENADA_EN_Y_DE_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void TestSobrePosicionQueAunNoImplemente(){

    }

    @Test
    public void TestPosicionSeMueveParaArriba(){
        Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO, tablero);
        Posicion posicionFinal =  new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO + DISTANCIA_DE_MOVIMIENTO, tablero);

        posicion = posicion.moverArriba(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void TestPosicionSeMueveParaAbajo(){
        Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO, tablero);
        Posicion posicionFinal =  new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO - DISTANCIA_DE_MOVIMIENTO, tablero);

        posicion = posicion.moverAbajo(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void TestPosicionSeMueveParaLaIzquierda(){
        Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO, tablero);
        Posicion posicionFinal =  new Posicion(COORDENADA_EN_X_DE_INICIO - DISTANCIA_DE_MOVIMIENTO, COORDENADA_EN_Y_DE_INICIO, tablero);

        posicion = posicion.moverIzquierda(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void TestPosicionSeMueveParaLaDerecha(){
        Posicion posicion = new Posicion(COORDENADA_EN_X_DE_INICIO, COORDENADA_EN_Y_DE_INICIO, tablero);
        Posicion posicionFinal =  new Posicion(COORDENADA_EN_X_DE_INICIO + DISTANCIA_DE_MOVIMIENTO, COORDENADA_EN_Y_DE_INICIO, tablero);

        posicion = posicion.moverDerecha(tablero);

        assertTrue(posicion.esIgualA(posicionFinal));
    }

    @Test
    public void TestCrearLaPosicionFueraDeRangoLanzaUnaExcepcion(){
        assertThrows(PosicionFueraDeRangoException.class,
                ()->{
                    Posicion posicion = new Posicion(COORDENADA_FUERA_DE_RANGO,COORDENADA_FUERA_DE_RANGO, tablero);
                    posicion.moverAbajo(tablero);
                });
    }

    @Test
    public void TestMoverLaPosicionFueraDeRangoLanzaUnaExcepcion(){

        Posicion posicion = new Posicion(COORDENADA_BORDE,COORDENADA_BORDE, tablero);

        assertThrows(PosicionFueraDeRangoException.class,
                ()-> posicion.moverDerecha(tablero));

    }

}
