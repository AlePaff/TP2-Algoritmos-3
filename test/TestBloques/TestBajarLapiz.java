package test.TestBloques;

import Modelo.bloques.BajarLapiz;
import Modelo.bloques.MoverArriba;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBajarLapiz extends TestBloques {
    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();
        MoverArriba bloqueArriba = new MoverArriba();

        bloque.ejecutar(personaje, tablero);
        bloqueArriba.ejecutar(personaje, tablero);
        Posicion posicionFinal = posicion.haciaArriba(tablero);

        //sería repetir la prueba del personaje, masomenos

        assertFalse(tablero.estaPintado(posicionFinal));
    }
}
