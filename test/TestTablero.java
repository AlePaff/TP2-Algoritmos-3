import Modelo.bloques.Conjunto;
import Modelo.bloques.MoverDerecha;
import Modelo.bloques.Repeticion;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTablero {
    @Test
    public void TestTableroSeCreaCorrectamente() {
        Tablero tablero = new Tablero(15, 15);

        assertEquals(15, tablero.getAltura());
        assertEquals(15, tablero.getBase());
    }

    @Test
    public void PersonajeConLapizLevantadoNoDibuja() {
        Tablero tablero = new Tablero(15, 15);
        Personaje personaje = new Personaje(0, 0);

        personaje.moverDerecha(tablero);

        assertFalse(tablero.getCasillero(1, 0).estaPintado());
    }

    @Test
    public void PersonajeConLapizApoyadoSiDibuja() {
        Tablero tablero = new Tablero(15, 15);
        Personaje personaje = new Personaje(0, 0);
        personaje.bajarLapiz();

        personaje.moverDerecha(tablero);

        assertTrue(tablero.getCasillero(1, 0).estaPintado()) ;
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente(){
        Tablero tablero = new Tablero(15, 15);
        Personaje personaje = new Personaje(0, 0);
        Repeticion bloque = new Repeticion(new MoverDerecha(), 5);

        bloque.ejecutar(personaje, tablero);

        assertEquals(5, personaje.getPosicion().getPosX());
    }
}
