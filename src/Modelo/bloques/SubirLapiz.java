package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class SubirLapiz implements Bloque{

    @Override
    public void ejecutar(Personaje personaje, Posicion posicion, Tablero tablero) {
        personaje.subirLapiz();
    }
}