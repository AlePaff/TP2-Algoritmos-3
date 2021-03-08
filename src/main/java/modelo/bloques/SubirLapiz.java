package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class SubirLapiz extends Bloque {
    @Override
    public void ejecutar( Personaje personaje, Tablero tablero) {
        personaje.subirLapiz();
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.bajarLapiz();
    }
}