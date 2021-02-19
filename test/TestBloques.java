package test;

import Modelo.bloques.BajarLapiz;
import org.junit.jupiter.api.Test;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import Modelo.bloques.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBloques {
    public Personaje personaje = new Personaje(8, 8);
    public Tablero tablero = new Tablero(15,15);
    public Movimiento movimiento = new MovimientoSinInvertir();

    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertFalse(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloque = new SubirLapiz();

        personaje.bajarLapiz();
        bloque.ejecutar(movimiento,personaje, tablero);

        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(7, personaje.getPosicion().getPosY());
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(9, personaje.getPosicion().getPosY());
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(9, personaje.getPosicion().getPosX());
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(7, personaje.getPosicion().getPosX());
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {
        Personaje personaje = new Personaje(8, 8);
        Repeticion bloqueRepeticion = new Repeticion( 5);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueRepeticion.ejecutar(movimiento, personaje, tablero);

        assertEquals(13, personaje.getPosicion().getPosX());
        assertEquals(3, personaje.getPosicion().getPosY());

    }

    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        Personaje personaje = new Personaje(8, 8);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        bloqueInvertir.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        assertEquals(7,personaje.getPosicion().getPosX());
        assertEquals(9, personaje.getPosicion().getPosY());


    }

}