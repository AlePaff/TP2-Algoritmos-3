package TestBloques;

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
        Posicion posicionFinal = posicion.deAbajo(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = posicion.deArriba(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = posicion.aDerecha(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = posicion.aIzquierda(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }
}
