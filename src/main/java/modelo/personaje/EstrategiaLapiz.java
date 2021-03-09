package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public interface EstrategiaLapiz {
    void dibujar(Tablero tablero, Posicion posicion);

    String getNombre();
}
