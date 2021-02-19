package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public interface Bloque {

    void ejecutar(Regla regla,Personaje personaje, Tablero tablero);

}
