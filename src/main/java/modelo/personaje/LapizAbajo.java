package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public class LapizAbajo implements EstrategiaLapiz {
    String nombre = "LapizAbajo";

    public void dibujar(Tablero tablero, Posicion posicion) {
        tablero.dibujar(posicion);
    }

    public String getNombre(){
        return nombre;
    }
}


