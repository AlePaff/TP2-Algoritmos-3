package modelo.testBloques;

import modelo.bloques.*;
import modelo.personaje.Personaje;
import modelo.tablero.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalizado {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void testSeEjecutaCorrectamente () { //cambiar el nombre
        BloquePersonalizado bloque = new BloquePersonalizado();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        Posicion posicionFinal = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);
        bloque.agregarBloque(bloqueDerecha);

        bloque.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void testSeAgreganBloquesCorrectamente () {
        BloquePersonalizado bloque = new BloquePersonalizado();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        bloque.agregarBloque(bloqueDerecha);

        assertEquals(1, bloque.tamanio());
    }

    @Test
    public void testSeAgregaElNombreCorrectamente () { //es una buena prueba?
        BloquePersonalizado bloque = new BloquePersonalizado();

        bloque.setNombre("Juanito");

        assertEquals("Juanito", bloque.getNombre());
    }
}
