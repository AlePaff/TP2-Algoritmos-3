package test.TestBloques;

import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverDerecha;
import Modelo.bloques.Repeticion;
import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRepeticion extends TestBloques {
    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {

        int cantRepeticiones = 5;
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for(int i = 0; i < cantRepeticiones; i++){
            posicionFinal = (posicionFinal.aDerecha(tablero)).haciaAbajo(tablero);
        }

        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueRepeticion.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnEstaPosicion(posicionFinal));
    }
}
