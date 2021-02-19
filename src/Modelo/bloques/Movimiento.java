package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

import java.util.ArrayList;

public interface Movimiento {

        void moverseADerecha(Personaje personaje, Tablero tablero);
        void moverseAIzquierda(Personaje personaje, Tablero tablero);
        void moverseHaciaArriba(Personaje personaje, Tablero tablero);
        void moverseHaciaAbajo(Personaje personaje, Tablero tablero);
        void bajarElLapiz(Personaje personaje);
        void subirElLapiz(Personaje personaje);
        void repetirMovimiento(ArrayList<Bloque> bloques, int repeticiones, Personaje personaje, Tablero tablero);

    }

