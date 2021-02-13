package Modelo.personaje;

import Modelo.bloques.Bloque;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class LapizAbajo implements EstadoLapiz{

    public void hacerMovimiento(Personaje personaje, Bloque bloque, Posicion posicion, Tablero tablero) {
        bloque.ejecutar(personaje, posicion, tablero);
        /* dibujar */
    }

}


