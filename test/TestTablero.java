
import Modelo.bloques.MoverDerecha;
//import Modelo.bloques.Repeticion;
import Modelo.excepciones.CoordenadasInvalidasException;
import Modelo.personaje.Personaje;
import Modelo.tablero.Casillero;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {
    @Test
    public void TestTableroSeCreaCorrectamente() {
        Tablero tablero = new Tablero(15, 15);

        assertEquals(15, tablero.getAltura());
        assertEquals(15, tablero.getBase());
    }


    @Test
    public void TableroSeCreaConTodosLosCasillerosSinPintar() {
        Tablero tablero = new Tablero(15, 15);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++)
                assertFalse(tablero.getCasillero(i, j).estaPintado());
        }
    }

    @Test
    public void TableroDibujaEnElCasilleroIndicado() {
        Tablero tablero = new Tablero(15, 15);

        tablero.dibujar(0, 0);
        assertTrue(tablero.getCasillero(0, 0).estaPintado());

        tablero.dibujar(1, 0);
        assertTrue(tablero.getCasillero(1, 0).estaPintado());

        tablero.dibujar(5, 2);
        assertTrue(tablero.getCasillero(5, 2).estaPintado());
    }



}

