package modelo.testBloques;

import modelo.bloques.InvertirComportamiento;
import modelo.bloques.*;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInvertirComportamiento {
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void testInvierteBloqueMoverDerecha() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = (posicion.moverIzquierda(tablero));

        bloqueInvertir.agregarBloque(new MoverDerecha());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueMoverIzquierda() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = (posicion.moverDerecha(tablero));

        bloqueInvertir.agregarBloque(new MoverIzquierda());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueMoverArriba() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = (posicion.moverAbajo(tablero));

        bloqueInvertir.agregarBloque(new MoverArriba());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueMoverAbajo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = (posicion.moverArriba(tablero));

        bloqueInvertir.agregarBloque(new MoverAbajo());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueSubirLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = (posicion.moverArriba(tablero));

        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.ejecutar(personaje,tablero);
        new MoverArriba().ejecutar(personaje,tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void testInvierteBloqueBajarLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = (posicion.moverArriba(tablero));

        bloqueInvertir.agregarBloque(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertFalse(tablero.estaPintado(posicionFinal));

    }

    @Test
    public void testInvierteVariosBloquesAlMismoTiempo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.moverArriba(tablero)).moverIzquierda(tablero);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueRepeticionConUnSoloBloqueAdentro() {
        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++) {
            posicionFinal = posicionFinal.moverIzquierda(tablero);
        }
        bloqueRepeticion.agregarBloque(bloqueDerecha);
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueRepeticionConVariosBloquesAdentro() {
        int cantRepeticiones = 5;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++) {
            posicionFinal = posicionFinal.moverDerecha(tablero).moverArriba(tablero);
        }
        bloqueRepeticion.agregarBloque(bloqueIzquierda);
        bloqueRepeticion.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteAlBloqueInvertirComportamiento() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        InvertirComportamiento bloqueInvertirAux = new InvertirComportamiento();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = (posicion.moverAbajo(tablero));

        bloqueInvertirAux.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueInvertirAux);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteAlBloquePersonalizado() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BloquePersonalizado bloquePersonalizado= new BloquePersonalizado();
        Posicion posicionFinal = (posicion.moverArriba(tablero));
        MoverAbajo bloqueAbajo = new MoverAbajo();
        for(int x = 0; x < 3 ; x++){
            posicionFinal = (posicionFinal.moverArriba(tablero));
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
