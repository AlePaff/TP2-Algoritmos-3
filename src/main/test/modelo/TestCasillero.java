package modelo;

import modelo.tablero.Casillero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCasillero {

    @Test
    public void testCasilleroSeCreaSinPintar(){

        Casillero casillero = new Casillero();

        assertFalse(casillero.estaPintado());
    }

    @Test
    public void testCasilleroSePintaCorrectamente(){

        Casillero casillero = new Casillero();
        casillero.pintar();

        assertTrue(casillero.estaPintado());
    }

    @Test
    public void testCasilleroSeDespintaCorrectamente(){

        Casillero casillero = new Casillero();
        casillero.pintar();

        casillero.despintar();

        assertFalse(casillero.estaPintado());
    }
}
