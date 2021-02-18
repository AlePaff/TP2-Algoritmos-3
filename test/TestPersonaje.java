import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaje{
    public Personaje personaje = new Personaje(8,8);
    public Tablero tablero = new Tablero(15, 15);


    @Test
    public void TestPersonajeSeCreaConLapizArriba(){

        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestPersonajeBajaYSubeElLapiz(){

        personaje.bajarLapiz();
        assertFalse(personaje.lapizLevantado());

        personaje.subirLapiz();
        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestPersonajeSeMueveADerecha(){

        personaje.moverDerecha(tablero);

        assertEquals(9, personaje.getPosicion().getPosX());

    }

    @Test
    public void TestPersonajeSeMueveAIzquierda(){

        personaje.moverIzquierda(tablero);

        assertEquals(7, personaje.getPosicion().getPosX());
    }

    @Test
    public void TestPersonajeSeMueveArriba(){

        personaje.moverArriba(tablero);

        assertEquals(9, personaje.getPosicion().getPosY());
    }

    @Test
    public void TestPersonajeSeMueveAbajo(){

        personaje.moverAbajo(tablero);

        assertEquals(7, personaje.getPosicion().getPosY());

    }

    @Test
    public void PersonajeConLapizLevantadoNoDibuja() {
        personaje.moverDerecha(tablero);

        assertFalse(tablero.getCasillero(9, 8).estaPintado());
    }

    @Test
    public void PersonajeConLapizApoyadoSiDibuja() {
        personaje.bajarLapiz();
        personaje.moverDerecha(tablero);

        assertTrue(tablero.getCasillero(9, 8).estaPintado()) ;
    }


    @Test
    public void PersonajeSeMueveConLapizArribaYAbajoYDibujaCorrectamente(){
        personaje.moverAbajo(tablero);
        personaje.bajarLapiz();
        personaje.moverAbajo(tablero);
        personaje.moverDerecha(tablero);
        personaje.subirLapiz();
        personaje.moverArriba(tablero);
        personaje.moverArriba(tablero);
        personaje.bajarLapiz();
        personaje.moverIzquierda(tablero);


        assertFalse(tablero.getCasillero(8,7).estaPintado());
        assertTrue(tablero.getCasillero(8,6).estaPintado());
        assertTrue(tablero.getCasillero(9,6).estaPintado());
        assertFalse(tablero.getCasillero(9,7).estaPintado());
        assertFalse(tablero.getCasillero(9,8).estaPintado());
        assertTrue(tablero.getCasillero(8,8).estaPintado());

    }
}