package modelo.testBloques;

import modelo.bloques.*;
import modelo.personaje.Personaje;
import modelo.tablero.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalizado {
    protected static final int BASE = 100;
    protected static final int ALTURA = 100;
    protected static final int COORD_X_INICIO = 50;
    protected static final int COORD_Y_INICIO = 50;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    protected final int RANGO_DE_MOVIMIENTO = personaje.RANGO_DE_MOVIMIENTO;

    @Test
    public void testSeEjecutaCorrectamente () {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        Posicion posicionFinal = new Posicion(COORD_X_INICIO + RANGO_DE_MOVIMIENTO, COORD_Y_INICIO, tablero);

        bloquePersonalizado.agregarBloque(new MoverDerecha());
        bloquePersonalizado.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testSeAgreganBloquesCorrectamente () {
        BloquePersonalizado bloque = new BloquePersonalizado();
        bloque.agregarBloque(new MoverDerecha());

        assertEquals(1, bloque.tamanio());
    }

    @Test
    public void testSeAgregaElNombreCorrectamente () { //es una buena prueba?
        BloquePersonalizado bloque = new BloquePersonalizado();

        bloque.setNombre("Juanito");

        assertEquals("Juanito", bloque.getNombre());
    }
}
