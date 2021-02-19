package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

import java.util.ArrayList;

public class MovimientoInvertido implements Movimiento{
    public void moverseADerecha(Personaje personaje, Tablero tablero) {

        personaje.moverIzquierda(tablero);
    }

    public void moverseAIzquierda(Personaje personaje, Tablero tablero) {

        personaje.moverDerecha(tablero);
    }

    public void moverseHaciaArriba(Personaje personaje, Tablero tablero) {

        personaje.moverAbajo(tablero);
    }

    public void moverseHaciaAbajo(Personaje personaje, Tablero tablero) {

        personaje.moverArriba(tablero);
    }

    public void bajarElLapiz(Personaje personaje) {

        personaje.subirLapiz();
    }

    public void subirElLapiz(Personaje personaje) {

        personaje.bajarLapiz();
    }

    public void repetirMovimiento(ArrayList<Bloque> bloques, int repeticiones, Personaje personaje, Tablero tablero){
        for (int i = 0; i < repeticiones; i++){
            for (Bloque bloque : bloques) {
                bloque.ejecutar(this, personaje, tablero);
            }
        }
    }
}
