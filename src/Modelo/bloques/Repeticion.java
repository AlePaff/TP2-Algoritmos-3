package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class Repeticion implements Bloque {
    public int repeticiones;
    Bloque bloque;

    public Repeticion(Bloque bloque, int repeticiones) {
        this.repeticiones = repeticiones;
        this.bloque = bloque;
    }


    @Override
    public void ejecutar(Movimiento movimiento,Personaje personaje, Tablero tablero){
            movimiento.repetirMovimiento(bloque,repeticiones,personaje,tablero);
    }
}

