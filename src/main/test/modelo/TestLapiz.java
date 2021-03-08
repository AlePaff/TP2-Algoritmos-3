package modelo;

import modelo.personaje.Lapiz;
import modelo.personaje.LapizAbajo;
import modelo.personaje.LapizArriba;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLapiz {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X = 8;
    protected static final int COORD_Y = 8;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X,COORD_Y, tablero);
    public Lapiz lapiz = new Lapiz();

    @Test
    public void testLapizDibujaConLapizAbajo(){
        lapiz.setEstrategia(new LapizAbajo());
        lapiz.dibujar(tablero, posicion);

        assertTrue(tablero.estaPintado(posicion));
    }

    @Test
    public void testLapizNoDibujaConLapizAbajo(){
        lapiz.setEstrategia(new LapizArriba());
        lapiz.dibujar(tablero, posicion);

        assertFalse(tablero.estaPintado(posicion));
    }
}
