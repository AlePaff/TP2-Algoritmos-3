package test.TestBloques;

import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverArriba;
import Modelo.bloques.MoverDerecha;
import Modelo.bloques.MoverIzquierda;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMover extends TestBloques {
    @Test
    public void TestBloqueMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();
        Posicion posicionFinal = posicion.haciaAbajo(tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = posicion.haciaArriba(tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = posicion.aDerecha(tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = posicion.aIzquierda(tablero);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
}
