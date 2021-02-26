package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public interface Bloque {

    void ejecutar(Personaje personaje, Tablero tablero);

    void ejecutarInvertido(Personaje personaje, Tablero tablero);

}
