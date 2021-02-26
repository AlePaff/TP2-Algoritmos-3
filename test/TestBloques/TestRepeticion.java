package TestBloques;

import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverDerecha;
import Modelo.bloques.Repeticion;
import Modelo.excepciones.RepeticionesNegativasException;
import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRepeticion {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;
    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);

    @Test
    public void RepeticionSeEjecutaCorrectamente() {
        int cantRepeticiones = 5;
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for (int i = 0; i < cantRepeticiones; i++)
            posicionFinal.aDerecha(tablero).haciaAbajo(tablero);

        bloqueRepeticion.agregarBloque(bloqueDerecha);
        bloqueRepeticion.agregarBloque(bloqueAbajo);
        bloqueRepeticion.ejecutar(personaje, tablero);

        assertTrue(personaje.estaEnPosicion(posicionFinal));
    }

    @Test
    public void NoAdmiteRepeticionesNegativas() { //COMPLETAR, NO TESTEA BIEN LA EXCEPCION
        int cantRepeticiones = -1;

        try{
            new Repeticion(cantRepeticiones);
        } catch (RepeticionesNegativasException e){
        }
    }
}
