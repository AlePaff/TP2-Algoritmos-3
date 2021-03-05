package modelo.testBloques;

import modelo.bloques.MoverAbajo;
import modelo.bloques.MoverDerecha;
import modelo.bloques.Repeticion;
import modelo.excepciones.RepeticionesNegativasException;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRepeticion {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void RepeticionSeEjecutaCorrectamente() {
        int cantRepeticiones = 5;
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++)
            posicionFinal = posicionFinal.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO).moverAbajo(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloqueRepeticion.agregarBloque(bloqueDerecha);
        bloqueRepeticion.agregarBloque(bloqueAbajo);
        bloqueRepeticion.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void NoAdmiteRepeticionesNegativas() {
        int cantRepeticiones = -1;

        assertThrows(RepeticionesNegativasException.class,
                ()-> new Repeticion(cantRepeticiones));
    }
}
