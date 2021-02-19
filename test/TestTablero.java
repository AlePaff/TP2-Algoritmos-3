package test;
//import Modelo.bloques.Repeticion;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {
    @Test
    public void TestTableroSeCreaCorrectamente() {
        Tablero tablero = new Tablero(15,15);


        assertEquals(15, tablero.getAltura());
        assertEquals(15, tablero.getBase());
    }


    @Test
    public void TableroSeCreaConTodosLosCasillerosSinPintar() {
        Tablero tablero = new Tablero(15,15);


        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++)
                assertFalse(tablero.getCasillero(i, j).estaPintado());
        }
    }

    @Test
    public void TableroDibujaEnElCasilleroIndicado() {
        Tablero tablero = new Tablero(15,15);
        Posicion posicion1 = new Posicion(0,1);
        Posicion posicion2 = new Posicion(1,0);
        Posicion posicion3 = new Posicion(5,2);


        tablero.dibujar(posicion1);
        assertTrue(tablero.getCasillero(0, 1).estaPintado());

        tablero.dibujar(posicion2);
        assertTrue(tablero.getCasillero(1, 0).estaPintado());

        tablero.dibujar(posicion3);
        assertTrue(tablero.getCasillero(5, 2).estaPintado());
    }


}

