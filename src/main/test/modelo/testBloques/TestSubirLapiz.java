package modelo.testBloques;

import modelo.bloques.BajarLapiz;
import modelo.bloques.MoverDerecha;
import modelo.bloques.SubirLapiz;
import modelo.bloques.MoverArriba;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSubirLapiz {
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void testSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloqueSubirLapiz = new SubirLapiz();
        MoverDerecha bloqueMoverDerecha = new MoverDerecha();

        bloqueSubirLapiz.ejecutar(personaje, tablero);
        bloqueMoverDerecha.ejecutar(personaje, tablero);

        assertFalse(tablero.estaPintado(personaje.getPosicion()));

    }
}
