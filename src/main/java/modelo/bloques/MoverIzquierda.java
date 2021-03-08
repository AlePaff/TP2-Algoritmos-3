package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class MoverIzquierda extends Bloque{

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.moverIzquierda(tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.moverDerecha(tablero);
    }
}
