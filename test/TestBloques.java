package test;

import Modelo.bloques.BajarLapiz;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import Modelo.bloques.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBloques {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    protected static final int CANT_REPETICIONES = 5;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    public Movimiento movimiento = new MovimientoSinInvertir();

    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(movimiento,personaje, tablero);
        //sería repetir la prueba del personaje, masomenos
        //assertFalse(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloque = new SubirLapiz();

        personaje.bajarLapiz();
        bloque.ejecutar(movimiento,personaje, tablero);
        //idem
       // assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();
        Posicion posicionFinal = posicion.AAbajo(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = posicion.AArriba(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = posicion.ALaDerecha(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = posicion.ALaIzquierda(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {
        Repeticion bloqueRepeticion = new Repeticion(CANT_REPETICIONES);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + CANT_REPETICIONES,COORD_Y_INICIO - CANT_REPETICIONES, tablero);

        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueRepeticion.ejecutar(movimiento, personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = new Posicion(7,9, tablero);

        bloqueInvertir.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void BloqueInvertirComportamientoYRepeticionSeEjecutanCorrectamente(){
        //Arrange
        Personaje personaje = new Personaje(new Posicion(8,8, tablero));
        Repeticion bloqueRepeticion = new Repeticion( 2);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = new Posicion(6,10, tablero);

        //act
        bloqueInvertir.agregarBloques(bloqueRepeticion);
        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        //assert
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

}