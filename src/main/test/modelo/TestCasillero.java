package modelo;

import modelo.tablero.Casillero;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCasillero {

    @Test
    public void TestCasilleroSeCreaSinPintar(){

        Casillero casillero = new Casillero();

        assertFalse(casillero.estaPintado());
    }

    @Test
    public void TestCasilleroSePintaCorrectamente(){

        Casillero casillero = new Casillero();
        casillero.pintar();

        assertTrue(casillero.estaPintado());
    }

    @Test
    public void TestCasilleroSeDespintaCorrectamente(){

        Casillero casillero = new Casillero();
        casillero.pintar();

        casillero.despintar();

        assertFalse(casillero.estaPintado());
    }
}
