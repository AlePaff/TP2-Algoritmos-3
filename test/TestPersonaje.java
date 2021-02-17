import Modelo.bloques.*;
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
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();
        Tablero tablero = new Tablero(15, 15);
        
        bloqueBajar.ejecutar(personaje, tablero);
        assertFalse(personaje.lapizLevantado());
        
        bloqueSubir.ejecutar(personaje, tablero);
        assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestPersonajeSeMueveADerecha(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);
        MoverDerecha bloqueDerecha = new MoverDerecha();

        bloqueDerecha.ejecutar(personaje, tablero);
        assertEquals(9, personaje.getPosicion().getPosX());

    }

    @Test
    public void TestPersonajeSeMueveAIzquierda(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);
        MoverIzquierda bloqueIzquierda = new MoverIzquierda();
        bloqueIzquierda.ejecutar(personaje, tablero);
        assertEquals(7, personaje.getPosicion().getPosX());

    }

    @Test
    public void TestPersonajeSeMueveArriba(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);
        
        MoverArriba bloqueArriba = new MoverArriba();
        bloqueArriba.ejecutar(personaje, tablero);
        
        assertEquals(9, personaje.getPosicion().getPosY());

    }

    @Test
    public void TestPersonajeSeMueveAbajo(){
        Personaje personaje = new Personaje(8,8);
        Tablero tablero = new Tablero(15, 15);
        
        MoverAbajo bloqueAbajo = new MoverAbajo();
        bloqueAbajo.ejecutar(personaje, tablero);
        
        assertEquals(7, personaje.getPosicion().getPosY());

    }
}