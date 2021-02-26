package TestBloques;

import Modelo.bloques.InvertirComportamiento;
import Modelo.bloques.*;
import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvertirComportamiento {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void InvierteBloqueMoverDerecha() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = (posicion.aIzquierda(tablero));

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteBloqueMoverIzquierda() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        Posicion posicionFinal = (posicion.aDerecha(tablero));

        bloqueInvertir.agregarBloque(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueMoverArriba() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.haciaAbajo(tablero));

        bloqueInvertir.agregarBloque(bloqueArriba);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueMoverAbajo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.haciaArriba(tablero));

        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueSubirLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        SubirLapiz bloqueSubirLapiz = new SubirLapiz();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.haciaArriba(tablero));

        bloqueInvertir.agregarBloque(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void InvierteBloqueBajarLApiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.haciaArriba(tablero));

        bloqueInvertir.agregarBloque(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertFalse(tablero.estaPintado(posicionFinal));

    }

    @Test
    public void InvierteVariosBloquesAlMismoTiempo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.haciaArriba(tablero)).aIzquierda(tablero);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteBloqueRepeticionConUnSoloBloqueAdentro() {
        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++)
            posicionFinal.aIzquierda(tablero);

        bloqueRepeticion.agregarBloque(bloqueDerecha);
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteBloqueRepeticionConVariosBloquesAdentro() {
        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++)
            posicionFinal.aDerecha(tablero).haciaArriba(tablero);

        bloqueRepeticion.agregarBloque(bloqueIzquierda);
        bloqueRepeticion.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteAlBloqueInvertirComportamiento() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        InvertirComportamiento bloqueInvertirAux = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.haciaAbajo(tablero));

        bloqueInvertirAux.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueInvertirAux);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
}
