package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class SubirLapiz implements Bloque{

    @Override
    public void ejecutar( Personaje personaje, Tablero tablero) {
        personaje.subirLapiz();
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.bajarLapiz();
    }
}