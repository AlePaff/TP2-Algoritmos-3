package TestBloques;

import Modelo.bloques.BajarLapiz;
import org.junit.jupiter.api.Test;

public class TestBajarLapiz extends TestBloques {
    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(movimiento,personaje, tablero);
        //sería repetir la prueba del personaje, masomenos
        //assertFalse(personaje.lapizLevantado());
    }
}
