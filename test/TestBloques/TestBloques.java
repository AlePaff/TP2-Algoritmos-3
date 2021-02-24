package TestBloques;

import Modelo.tablero.Posicion;
import org.junit.jupiter.api.Test;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import Modelo.bloques.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBloques {
    protected static final int BASE = 15;
    protected static final int ALTURA = 15;
    protected static final int COORD_X_INICIO = 8;
    protected static final int COORD_Y_INICIO = 8;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    public Movimiento movimiento = new MovimientoSinInvertir();

    @Test
    public void BloqueInvertirComportamientoYRepeticionSeEjecutanCorrectamente(){

        //Arrange
        int cantRepeticiones = 2;
        Repeticion bloqueRepeticion = new Repeticion(cantRepeticiones);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for(int i = 0; i < cantRepeticiones; i++){
            posicionFinal = (posicionFinal.aIzquierda(tablero)).deArriba(tablero);
        }

        //act
        bloqueInvertir.agregarBloques(bloqueRepeticion);
        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        //assert
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

}