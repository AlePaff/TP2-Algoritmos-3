package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class MovimientoSinInvertir implements Movimiento{
    public void moverseADerecha(Personaje personaje, Tablero tablero) {

        personaje.moverDerecha(tablero);
    }

    public void moverseAIzquierda(Personaje personaje, Tablero tablero) {

        personaje.moverIzquierda(tablero);
    }

    public void moverseHaciaArriba(Personaje personaje, Tablero tablero) {

        personaje.moverArriba(tablero);
    }

    public void moverseHaciaAbajo(Personaje personaje, Tablero tablero) {

        personaje.moverAbajo(tablero);
    }

    public void bajarElLapiz(Personaje personaje) {

        personaje.bajarLapiz();
    }

    public void subirElLapiz(Personaje personaje) {

        personaje.subirLapiz();
    }

    public void repetirMovimiento(Bloque bloque,int repeticiones,Personaje personaje,Tablero tablero){
        for (int i = 0; i < repeticiones; i++){
            bloque.ejecutar (this,personaje,tablero);
        }
    }
}
