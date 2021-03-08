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
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    protected final int RANGO_DE_MOVIMIENTO = personaje.RANGO_DE_MOVIMIENTO;

    @Test
    public void testRepeticionSeEjecutaCorrectamente() {
        int cantRepeticiones = 3;
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + cantRepeticiones*RANGO_DE_MOVIMIENTO, COORD_Y_INICIO + cantRepeticiones*RANGO_DE_MOVIMIENTO, tablero);

        bloqueRepeticion.agregarBloque(new MoverDerecha());
        bloqueRepeticion.agregarBloque(new MoverAbajo());
        bloqueRepeticion.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testNoAdmiteRepeticionesNegativas() {
        int cantRepeticiones = -1;

        assertThrows(RepeticionesNegativasException.class,
                ()-> new Repeticion(cantRepeticiones));
    }
}
