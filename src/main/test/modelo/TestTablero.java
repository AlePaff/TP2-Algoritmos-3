package modelo;

import modelo.excepciones.BaseOAlturaNegativosONulosException;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    Tablero tablero = new Tablero(BASE,ALTURA);

    @Test
    public void testTableroSeCreaCorrectamente() {
        assertEquals(BASE, tablero.getAltura());
        assertEquals(ALTURA, tablero.getBase());
    }

    @Test
    public void testTableroSeCreaSinDibujo() {
        Posicion posicion;
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < ALTURA; j++){
                posicion = new Posicion(i, j, tablero);
                assertFalse(tablero.estaPintado(posicion));
            }
        }
    }

    @Test
    public void testTableroDibujaEnPosicionIndicada() {
        Posicion posicion = new Posicion(0, 1, tablero);

        tablero.dibujar(posicion);

        assertTrue(tablero.estaPintado(posicion));

    }

    @Test
    public void testTableroDibujaEnPosicionesIndicadas() {
        Posicion posicion1 = new Posicion(1,0, tablero);
        Posicion posicion2 = new Posicion(5,2, tablero);

        tablero.dibujar(posicion1);
        tablero.dibujar(posicion2);

        assertTrue(tablero.estaPintado(posicion1));
        assertTrue(tablero.estaPintado(posicion2));
    }

    @Test
    public void testDibujoSeBorraCorrectamente() {
        Posicion posicion1 = new Posicion(1,0, tablero);
        Posicion posicion2 = new Posicion(5,2, tablero);

        tablero.dibujar(posicion1);
        tablero.dibujar(posicion2);

        tablero.eliminarDibujo();

        assertFalse(tablero.estaPintado(posicion1));
        assertFalse(tablero.estaPintado(posicion2));
    }

    @Test
    public void testNoSePuedeCrearUnTableroConCoordenadasNegativas() {

        assertThrows(BaseOAlturaNegativosONulosException.class,
                ()->{
                    Tablero tablero = new Tablero(-1,-2);
                });
    }
}