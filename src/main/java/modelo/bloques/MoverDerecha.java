package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class MoverDerecha implements Bloque{
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.moverDerecha(tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.moverIzquierda(tablero);
    }
}
