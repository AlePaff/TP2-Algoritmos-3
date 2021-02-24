package TestBloques;

import Modelo.bloques.InvertirComportamiento;
import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverDerecha;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvertirComportamiento extends TestBloques {
    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = (posicion.deArriba(tablero)).aIzquierda(tablero);

        bloqueInvertir.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }
}
