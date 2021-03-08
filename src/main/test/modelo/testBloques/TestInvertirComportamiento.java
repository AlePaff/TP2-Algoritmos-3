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
    protected final int RANGO_DE_MOVIMIENTO = personaje.RANGO_DE_MOVIMIENTO;

    @Test
    public void testInvierteBloqueMoverDerecha() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO - RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloqueInvertir.agregarBloque(new MoverDerecha());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueMoverIzquierda() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloqueInvertir.agregarBloque(new MoverIzquierda());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueMoverArriba() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO + RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertir.agregarBloque(new MoverArriba());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueMoverAbajo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertir.agregarBloque(new MoverAbajo());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
    @Test
    public void testInvierteBloqueSubirLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertir.agregarBloque(new SubirLapiz());
        bloqueInvertir.ejecutar(personaje,tablero);
        new MoverArriba().ejecutar(personaje,tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }

    @Test
    public void testInvierteBloqueBajarLapiz() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverArriba bloqueArriba = new MoverArriba();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertir.agregarBloque(new BajarLapiz());
        bloqueInvertir.ejecutar(personaje,tablero);
        bloqueArriba.ejecutar(personaje,tablero);

        assertFalse(tablero.estaPintado(posicionFinal));

    }

    @Test
    public void testInvierteVariosBloquesAlMismoTiempo() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO - RANGO_DE_MOVIMIENTO, COORD_Y_INICIO - RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertir.agregarBloque(new MoverDerecha());
        bloqueInvertir.agregarBloque(new MoverAbajo());
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueRepeticionConUnSoloBloqueAdentro() {
        int cantRepeticiones = 3;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        Posicion posicionFinal = new Posicion(COORD_X_INICIO - cantRepeticiones*RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloqueRepeticion.agregarBloque(new MoverDerecha());
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteBloqueRepeticionConVariosBloquesAdentro() {
        int cantRepeticiones = 3;
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + cantRepeticiones*RANGO_DE_MOVIMIENTO, COORD_Y_INICIO - cantRepeticiones*RANGO_DE_MOVIMIENTO, tablero);

        bloqueRepeticion.agregarBloque(new MoverIzquierda());
        bloqueRepeticion.agregarBloque(new MoverAbajo());
        bloqueInvertir.agregarBloque(bloqueRepeticion);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteAlBloqueInvertirComportamiento() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        InvertirComportamiento bloqueInvertirInterior = new InvertirComportamiento();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO + RANGO_DE_MOVIMIENTO, tablero);

        bloqueInvertirInterior.agregarBloque(new MoverAbajo());
        bloqueInvertir.agregarBloque(bloqueInvertirInterior);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testInvierteAlBloquePersonalizado() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        BloquePersonalizado bloquePersonalizado= new BloquePersonalizado();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO, COORD_Y_INICIO - 3*RANGO_DE_MOVIMIENTO, tablero);
        MoverAbajo bloqueAbajo = new MoverAbajo();
        bloquePersonalizado.agregarBloque(bloqueAbajo);
        bloquePersonalizado.agregarBloque(bloqueAbajo);
        bloquePersonalizado.agregarBloque(bloqueAbajo);

        bloqueInvertir.agregarBloque(bloquePersonalizado);
        bloqueInvertir.ejecutar(personaje,tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }
}
