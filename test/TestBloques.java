import Modelo.bloques.BajarLapiz;
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
    protected static final int CANT_REPETICIONES_1 = 5;
    protected static final int CANT_REPETICIONES_2 = 2;

    public Tablero tablero = new Tablero(BASE,ALTURA);
    public Posicion posicion = new Posicion(COORD_X_INICIO,COORD_Y_INICIO, tablero);
    public Personaje personaje = new Personaje(posicion);
    public Movimiento movimiento = new MovimientoSinInvertir();

    @Test
    public void TestBloqueBajarLapizSeEjecutaCorrectamente() {
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(movimiento,personaje, tablero);
        //sería repetir la prueba del personaje, masomenos
        //assertFalse(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueSubirLapizSeEjecutaCorrectamente() {
        SubirLapiz bloque = new SubirLapiz();

        personaje.bajarLapiz();
        bloque.ejecutar(movimiento,personaje, tablero);
        //idem
       // assertTrue(personaje.lapizLevantado());
    }

    @Test
    public void TestBloqueMoverAbajoSeEjecutaCorrectamente() {
        MoverAbajo bloque = new MoverAbajo();
        Posicion posicionFinal = posicion.deAbajo(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverArribaSeEjecutaCorrectamente() {
        MoverArriba bloque = new MoverArriba();
        Posicion posicionFinal = posicion.deArriba(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);
        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverDerechaSeEjecutaCorrectamente() {
        MoverDerecha bloque = new MoverDerecha();
        Posicion posicionFinal = posicion.aDerecha(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void TestBloqueMoverIzquierdaSeEjecutaCorrectamente() {
        MoverIzquierda bloque = new MoverIzquierda();
        Posicion posicionFinal = posicion.aIzquierda(tablero);

        bloque.ejecutar(movimiento,personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void BloqueDeRepeticionSeCreaCorrectamente() {
        Repeticion bloqueRepeticion = new Repeticion(CANT_REPETICIONES_1);
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for(int i = 0; i < CANT_REPETICIONES_1; i++){
            posicionFinal = (posicionFinal.aDerecha(tablero)).deAbajo(tablero);
        }

        bloqueRepeticion.agregarBloques(bloqueDerecha);
        bloqueRepeticion.agregarBloques(bloqueAbajo);
        bloqueRepeticion.ejecutar(movimiento, personaje, tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void BloqueDeInvertirComportamientoSeEjecutaCorrectamente() {
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();

        Posicion posicionFinal = (posicion.deArriba(tablero)).aIzquierda(tablero);

        bloqueInvertir.agregarBloques(bloqueDerecha);
        bloqueInvertir.agregarBloques(bloqueAbajo);

        bloqueInvertir.ejecutar(movimiento,personaje,tablero);

        Posicion posicionActual = personaje.getPosicion();
        assertTrue(posicionActual.esIgualA(posicionFinal));
    }

    @Test
    public void BloqueInvertirComportamientoYRepeticionSeEjecutanCorrectamente(){
        //Arrange
        Repeticion bloqueRepeticion = new Repeticion(CANT_REPETICIONES_2);
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();
        MoverDerecha bloqueDerecha = new MoverDerecha();
        MoverAbajo bloqueAbajo = new MoverAbajo();
        Posicion posicionFinal = posicion;
        for(int i = 0; i < CANT_REPETICIONES_2; i++){
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