package TestBloques;

import Modelo.bloques.SubirLapiz;
import org.junit.jupiter.api.Test;

public class TestSubirLapiz extends TestBloques {
    @Test
    public void TestBloqueSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloque = new SubirLapiz();

        personaje.bajarLapiz();
        bloque.ejecutar(movimiento,personaje, tablero);
        //idem
        // assertTrue(personaje.lapizLevantado());
    }

}
