package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class MoverArriba extends Bloque{

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.moverArriba(tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.moverAbajo(tablero);
    }

}

