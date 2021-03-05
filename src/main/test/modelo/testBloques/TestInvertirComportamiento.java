package modelo.testBloques;

import modelo.bloques.InvertirComportamiento;
import modelo.bloques.*;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInvertirComportamiento {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void InvierteBloqueMoverDerecha() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = (posicion.moverIzquierda(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteBloqueMoverIzquierda() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        Posicion posicionFinal = (posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertir.agregarBloque(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueMoverArriba() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertir.agregarBloque(bloqueArriba);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueMoverAbajo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void InvierteBloqueSubirLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        SubirLapiz bloqueSubirLapiz = new SubirLapiz();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertir.agregarBloque(bloqueSubirLapiz);
        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void InvierteBloqueBajarLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO));

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
        Posicion posicionFinal = (posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO)).moverIzquierda(tablero, DISTANCIA_DE_MOVIMIENTO);

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
        for (int i = 0; i < cantRepeticiones; i++) {
            posicionFinal = posicionFinal.moverIzquierda(tablero, DISTANCIA_DE_MOVIMIENTO);
        }
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
        for (int i = 0; i < cantRepeticiones; i++) {
            posicionFinal = posicionFinal.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO).moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);
        }
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
        Posicion posicionFinal = (posicion.moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO));

        bloqueInvertirAux.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueInvertirAux);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void InvierteAlBloquePersonalizado() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BloquePersonalizado bloquePersonalizado= new BloquePersonalizado();
        Posicion posicionFinal = (posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO));
        MoverAbajo bloqueAbajo = new MoverAbajo();
        for(int x = 0; x < 3 ; x++){
            posicionFinal = (posicionFinal.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO));
        }

        bloquePersonalizado.agregarBloque(bloqueAbajo);
        bloquePersonalizado.agregarBloque(bloqueAbajo);
        bloquePersonalizado.agregarBloque(bloqueAbajo);
        bloquePersonalizado.agregarBloque(bloqueAbajo);

        bloqueInvertir.agregarBloque(bloquePersonalizado);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
}
