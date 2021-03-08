package modelo.testBloques;

import modelo.bloques.MoverAbajo;
import modelo.bloques.MoverArriba;
import modelo.bloques.MoverDerecha;
import modelo.bloques.MoverIzquierda;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMover {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void testMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();
        Posicion posicionFinal = posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = posicion.moverIzquierda(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
}
