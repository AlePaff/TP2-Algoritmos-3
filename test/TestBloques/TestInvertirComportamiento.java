package test.TestBloques;

import Modelo.bloques.InvertirComportamiento;
import Modelo.bloques.*;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvertirComportamiento extends TestBloques {

    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueMoverDerecha() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = (posicion.aIzquierda(tablero));
        bloqueInvertir.agregarBloques(bloqueDerecha);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueMoverIzquierda() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        Posicion posicionFinal = (posicion.aDerecha(tablero));
        bloqueInvertir.agregarBloques(bloqueIzquierda);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueMoverArriba() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverArriba bloqueArriba = new MoverArriba();

        Posicion posicionFinal = (posicion.haciaAbajo(tablero));
        bloqueInvertir.agregarBloques(bloqueArriba);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueMoverAbajo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.haciaArriba(tablero));
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueSubirLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        SubirLapiz bloqueSubirLapiz = new SubirLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        Posicion posicionFinal = (posicion.haciaArriba(tablero));
        bloqueInvertir.agregarBloques(bloqueSubirLapiz);

        //bloqueInvertir.agregarBloques(bloqueArriba);

        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueBajarLApiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        Posicion posicionFinal = (posicion.haciaArriba(tablero));

        bloqueInvertir.agregarBloques(bloqueBajarLapiz);
        //bloqueInvertir.agregarBloques(bloqueArriba);

        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertFalse(tablero.estaPintado(posicionFinal));

    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteVariosBloquesAlMismoTiempo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = (posicion.haciaArriba(tablero)).aIzquierda(tablero);

        bloqueInvertir.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueRepeticionConUnSoloBloqueAdentro() {
        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();

        Posicion posicionFinal = posicion;
        for(int i = 0; i < cantRepeticiones; i++){
            posicionFinal = (posicionFinal.aIzquierda(tablero));
        }
        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueRepeticion);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteBloqueRepeticionConVariosBloquesAdentro() {

        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = posicion;
        for(int i = 0; i < cantRepeticiones; i++){
            posicionFinal = (posicionFinal.aDerecha(tablero)).haciaArriba(tablero);
        }

        bloqueRepeticion.agregarBloques(bloqueIzquierda);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueInvertir.agregarBloques(bloqueRepeticion);

        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoInvierteAlBloqueInvertirComportamiento() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        InvertirComportamiento bloqueInvertirAux = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = (posicion.haciaAbajo(tablero));
        bloqueInvertirAux.agregarBloques(bloqueAbajo);
        bloqueInvertir.agregarBloques(bloqueInvertirAux);

        bloqueInvertirAux.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
}
