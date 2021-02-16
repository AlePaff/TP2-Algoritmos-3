import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    @Test
    public void TestPersonajeSeCreaConLapizArriba(){
        Personaje personaje = new Personaje();

        assertTrue(personaje.lapizLevantado());
    }


    @Test
    public void TestPersonajeBajaYSubeElLapiz(){
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        assertFalse(personaje.lapizLevantado());

        personaje.subirLapiz();
        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);

        personaje.moverDerecha(tablero);
        assertEquals(9, personaje.getPosicion().getPosX());

    }

    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);

        personaje.moverIzquierda(tablero);
        assertEquals(7, personaje.getPosicion().getPosX());

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);

        personaje.moverArriba(tablero);
        assertEquals(9, personaje.getPosicion().getPosY());

    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);

        personaje.moverAbajo(tablero);
        assertEquals(7, personaje.getPosicion().getPosY());

    }
}