package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class BajarLapiz implements Bloque{

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.bajarLapiz();
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.subirLapiz();
    }
}