import Modelo.bloques.BajarLapiz;
import org.junit.jupiter.api.Test;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import Modelo.bloques.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBloques {
    public Personaje personaje = new Personaje(8, 8);
    public Tablero tablero = new Tablero(15,15);
    public Movimiento movimiento = new MovimientoSinInvertir();

    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertFalse(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloque = new SubirLapiz();

        personaje.bajarLapiz();
        bloque.ejecutar(movimiento,personaje, tablero);

        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(7, personaje.getPosicion().getPosY());
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(9, personaje.getPosicion().getPosY());
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(9, personaje.getPosicion().getPosX());
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(7, personaje.getPosicion().getPosX());
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {
        Personaje personaje = new Personaje(0, 0);
        Repeticion bloque = new Repeticion(new MoverDerecha(), 5);
        //Movimiento movimiento = new MovimientoInvertido();

        bloque.ejecutar(movimiento,personaje, tablero);

        assertEquals(5, personaje.getPosicion().getPosX());
    }

    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        Movimiento movimiento = new MovimientoInvertido();
        MoverDerecha bloque = new MoverDerecha();
        MoverAbajo bloque1 = new MoverAbajo();

        bloque.ejecutar(movimiento,personaje,tablero);
        bloque1.ejecutar(movimiento,personaje,tablero);

        assertEquals(7,personaje.getPosicion().getPosX());
        assertEquals(9, personaje.getPosicion().getPosY());


    }
}