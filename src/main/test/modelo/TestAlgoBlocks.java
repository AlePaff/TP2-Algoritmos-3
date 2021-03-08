package modelo;

import modelo.AlgoBlocks;
import modelo.bloques.MoverDerecha;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgoBlocks {
    AlgoBlocks algoblocks = new AlgoBlocks();

    @Test
    public void testBloqueSeAgregaAlAlgoritmoCorrectamente(){
        MoverDerecha bloque = new MoverDerecha();
        algoblocks.agregarBloque(bloque);

        assertEquals(algoblocks.getAlgoritmo(), 1);
    }

    @Test
    public void testAlgoritmoSeEjecutaCorrectamente(){

    }

    @Test
    public void testReiniciarTableroBorraElAlgoritmo(){

    }

    @Test
    public void testReiniciarTableroBorraElDibujo(){

    }

    @Test
    public void test(){

    }
}
