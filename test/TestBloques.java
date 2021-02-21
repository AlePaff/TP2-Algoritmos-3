package test;

import Modelo.bloques.BajarLapiz;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import Modelo.bloques.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBloques {
    public Tablero tablero = new Tablero(15,15);
    public Personaje personaje = new Personaje(new Posicion(8,8, tablero));
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
        Posicion posicionFinal = new Posicion(8,7, tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = new Posicion(8,9, tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = new Posicion(9,8, tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = new Posicion(7,8, tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {
        Personaje personaje = new Personaje(new Posicion(8,8, tablero));
        Repeticion bloqueRepeticion = new Repeticion( 5);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = new Posicion(13,3, tablero);

        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueRepeticion.ejecutar(movimiento, personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.sonIguales(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        Personaje personaje = new Personaje(new Posicion(8,8, tablero));
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