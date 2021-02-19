package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class Repeticion extends Conjunto {
    public int repeticiones;

    public Repeticion( int repeticiones) {
        this.repeticiones = repeticiones;
    }


    @Override
    public void ejecutar(Movimiento movimiento,Personaje personaje, Tablero tablero){
            movimiento.repetirMovimiento(bloques, repeticiones, personaje,tablero);
    }
}

