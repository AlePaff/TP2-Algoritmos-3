package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public interface Movimiento {

        void moverseADerecha(Personaje personaje, Tablero tablero);
        void moverseAIzquierda(Personaje personaje, Tablero tablero);
        void moverseHaciaArriba(Personaje personaje, Tablero tablero);
        void moverseHaciaAbajo(Personaje personaje, Tablero tablero);
        void bajarElLapiz(Personaje personaje);
        void subirElLapiz(Personaje personaje);
        void repetirMovimiento(Bloque bloque,int repeticiones,Personaje personaje,Tablero tablero);

    }

