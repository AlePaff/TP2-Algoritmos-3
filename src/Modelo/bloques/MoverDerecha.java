package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class MoverDerecha implements Bloque{
    @Override
    public void ejecutar(Movimiento movimiento, Personaje personaje, Tablero tablero) {
        movimiento.moverseADerecha(personaje,tablero);
    }
}
