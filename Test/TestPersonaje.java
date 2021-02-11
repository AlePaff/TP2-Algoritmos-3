import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonaje{
    @Test
    public void TestPersonajeSeCreaConLapizArriba(){
        Personaje personaje = new Personaje();

        assertTrue(personaje.lapizArriba());
        }
}