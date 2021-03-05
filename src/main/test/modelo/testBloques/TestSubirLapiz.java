package modelo.testBloques;

import modelo.bloques.SubirLapiz;
import modelo.bloques.MoverArriba;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestSubirLapiz {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void SubirLapizSeEjecutaCorrectamente() {
        personaje.bajarLapiz();

        SubirLapiz bloqueSubirLapiz = new SubirLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        bloqueSubirLapiz.ejecutar(personaje, tablero);
        bloqueArriba.ejecutar(personaje, tablero);
        Posicion posicionFinal = posicion.moverArriba(tablero);

        assertFalse(tablero.estaPintado(posicionFinal));
    }
}
