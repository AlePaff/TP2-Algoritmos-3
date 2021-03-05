package modelo;

import modelo.excepciones.BaseOAlturaNegativosONulosException;
import modelo.excepciones.ElTableroDebeSerCuadradoException;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    Tablero tablero = new Tablero(BASE,ALTURA);

    @Test
    public void TestTableroSeCreaCorrectamente() {
        assertEquals(BASE, tablero.getAltura());
        assertEquals(ALTURA, tablero.getBase());
    }


    @Test
    public void TableroSeCreaConTodosLosCasillerosSinPintar() {
        for (int i = 0; i < BASE; i++) {
            for (int j = 0; j < ALTURA; j++){
                Posicion posicionIJ = new Posicion(i, j, tablero);
                assertFalse(tablero.estaPintado(posicionIJ));
            }
        }
    }

    @Test
    public void TableroDibujaEnElCasilleroIndicado() {
        Posicion posicion1 = new Posicion(0, 1, tablero);

        tablero.dibujar(posicion1);

        assertTrue(tablero.estaPintado(posicion1));

    }


    @Test
    public void TableroDibujaEnLosCasillerosIndicados() {
        Posicion posicion2 = new Posicion(1,0, tablero);
        Posicion posicion3 = new Posicion(5,2, tablero);

        tablero.dibujar(posicion2);
        tablero.dibujar(posicion3);

        assertTrue(tablero.estaPintado(posicion2));
        assertTrue(tablero.estaPintado(posicion3));
    }

    @Test
    public void NoSePuedeCrearUnTableroConCoordenadasNegativas() {

        assertThrows(BaseOAlturaNegativosONulosException.class,
                ()->{
                    Tablero tablero = new Tablero(-1,-2);
                    tablero.getAltura();
                });

    }

    @Test
    public void NoSePuedeCrearUnTableroNoCuadrado() {

        assertThrows(ElTableroDebeSerCuadradoException.class,
                ()->{
                    Tablero tablero = new Tablero(15,10);
                    tablero.getAltura();
                });

    }

}