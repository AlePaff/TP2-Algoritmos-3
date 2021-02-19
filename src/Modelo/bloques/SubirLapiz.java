package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class SubirLapiz implements Bloque{

    @Override
    public void ejecutar(Movimiento movimiento, Personaje personaje, Tablero tablero) {
        movimiento.subirElLapiz(personaje);
    }
}