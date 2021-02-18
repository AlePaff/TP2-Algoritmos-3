import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonaje{
    @Test
    public void TestPersonajeSeCreaConLapizArriba(){
        Personaje personaje = new Personaje();

        assertTrue(personaje.lapizArriba());
        }


    @Test
    public void TestPersonajeBajaYSubeElLapiz(){
        Personaje personaje = new Personaje();

        personaje.bajarLapiz();
        assertTrue(personaje.lapizAbajo());
        assertFalse(personaje.lapizArriba());

        personaje.subirLapiz();
        assertTrue(personaje.lapizArriba());
        assertFalse(personaje.lapizAbajo());
        
        }
}