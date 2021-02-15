package Modelo.personaje;

import Modelo.tablero.Tablero;

public class LapizAbajo implements EstadoLapiz{
    public void dibujar(Tablero tablero, int x, int y) {
        tablero.dibujar(x, y);
    }
}


