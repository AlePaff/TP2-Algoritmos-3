package modelo.testBloques;

import modelo.bloques.BajarLapiz;
import modelo.bloques.MoverArriba;
import modelo.bloques.MoverDerecha;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBajarLapiz {
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void testBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverDerecha bloqueMoverDerecha = new MoverDerecha();

        bloqueBajarLapiz.ejecutar(personaje, tablero);
        bloqueMoverDerecha.ejecutar(personaje, tablero);

        assertTrue(tablero.estaPintado(personaje.getPosicion()));
    }
}
