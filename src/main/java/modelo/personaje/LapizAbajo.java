package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public class LapizAbajo implements EstrategiaLapiz {
    public void dibujar(Tablero tablero, Posicion posicion) {
        tablero.dibujar(posicion);
    }
}


