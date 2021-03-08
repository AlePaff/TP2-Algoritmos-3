package modelo.testBloques;

import modelo.bloques.*;
import modelo.personaje.Personaje;
import modelo.tablero.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPersonalizado {
    protected static final int BASE = 25;
    protected static final int ALTURA = 25;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    protected final int DISTANCIA_DE_MOVIMIENTO = personaje.DISTANCIA_DE_MOVIMIENTO;

    @Test
    public void testSeEjecutaCorrectamente () {
        BloquePersonalizado bloquePersonalizado = new BloquePersonalizado();
        Posicion posicionFinal = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);

        bloquePersonalizado.agregarBloque(new MoverDerecha());
        bloquePersonalizado.ejecutar(personaje, tablero);

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
