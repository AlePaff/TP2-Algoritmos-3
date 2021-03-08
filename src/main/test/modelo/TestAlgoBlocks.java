package modelo;

import modelo.bloques.BajarLapiz;
import modelo.bloques.BloquePersonalizado;
import modelo.bloques.MoverAbajo;
import modelo.bloques.MoverDerecha;
import modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAlgoBlocks {
    AlgoBlocks algoblocks = new AlgoBlocks();

    @Test
    public void testMoverPersonajeSeEjecutaCorrectamente(){
        Posicion posicionInicial = algoblocks.getPosicionDelPersonaje();
        algoblocks.agregarBloque(new MoverDerecha());

        algoblocks.ejecutarAlgoritmo();

        assertFalse(algoblocks.getPosicionDelPersonaje().esIgualA(posicionInicial));
    }

    @Test
    public void testPersonajeDibuja(){
        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(new MoverDerecha());

        algoblocks.ejecutarAlgoritmo();
        Posicion posicionDibujada = algoblocks.getPosicionDelPersonaje();

        assertTrue(algoblocks.getPosicionesDibujadas().contains(posicionDibujada));
    }

    @Test
    public void testReiniciarAlgoritmoBorraElAlgoritmo(){
        Posicion posicionInicial = algoblocks.getPosicionDelPersonaje();
        algoblocks.agregarBloque(new MoverDerecha());
        algoblocks.agregarBloque(new MoverAbajo());

        algoblocks.reiniciarAlgoritmo();
        algoblocks.ejecutarAlgoritmo();

        assertTrue(algoblocks.getPosicionDelPersonaje().esIgualA(posicionInicial));
    }

    @Test
    public void testReiniciarTableroBorraElDibujo(){
        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(new MoverDerecha());
        algoblocks.agregarBloque(new MoverDerecha());

        algoblocks.ejecutarAlgoritmo();

        algoblocks.reiniciarTablero();
        assertEquals(algoblocks.getPosicionesDibujadas().size(), 0);
    }

    @Test
    public void testAlgoritmoSeGuardaCorrectamente(){
        algoblocks.agregarBloque(new BajarLapiz());
        algoblocks.agregarBloque(new MoverDerecha());
        BloquePersonalizado bloque = algoblocks.guardarAlgoritmo("nombre");

        algoblocks.reiniciarAlgoritmo();
        algoblocks.agregarBloque(bloque);
        algoblocks.ejecutarAlgoritmo();
        Posicion posicionDibujada = algoblocks.getPosicionDelPersonaje();

        assertTrue(algoblocks.getPosicionesDibujadas().contains(posicionDibujada));
    }
}
