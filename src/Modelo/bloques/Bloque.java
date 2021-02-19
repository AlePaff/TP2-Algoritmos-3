package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public interface Bloque {

    void ejecutar(Movimiento movimiento,Personaje personaje, Tablero tablero);

}
