package test.TestBloques;

import Modelo.bloques.BajarLapiz;
import Modelo.bloques.MoverArriba;
import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBajarLapiz {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void BajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        bloqueBajarLapiz.ejecutar(personaje, tablero);
        bloqueArriba.ejecutar(personaje, tablero);
        Posicion posicionFinal = posicion.moverArriba(tablero);

        assertTrue(tablero.estaPintado(posicionFinal));
    }
}
