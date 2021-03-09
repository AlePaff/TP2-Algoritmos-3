package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public class LapizArriba implements EstrategiaLapiz {
    String nombre = "LapizArriba";

    public void dibujar(Tablero tablero, Posicion posicion) {
    }

    public String getNombre(){
        return nombre;
    }
}
