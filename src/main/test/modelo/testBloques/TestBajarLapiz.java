package modelo.testBloques;

import modelo.bloques.BajarLapiz;
import modelo.bloques.MoverArriba;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
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
    protected final int DISTANCIA_DE_MOVIMIENTO = personaje.DISTANCIA_DE_MOVIMIENTO;

    @Test
    public void testBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        bloqueBajarLapiz.ejecutar(personaje, tablero);
        bloqueArriba.ejecutar(personaje, tablero);
        Posicion posicionFinal = posicion.moverArriba(tablero, DISTANCIA_DE_MOVIMIENTO);

        assertTrue(tablero.estaPintado(posicionFinal));
    }
}
