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
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    protected final int RANGO_DE_MOVIMIENTO = personaje.RANGO_DE_MOVIMIENTO;

    @Test
    public void testMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO + RANGO_DE_MOVIMIENTO, tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO - RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
}
