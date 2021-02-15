package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class MoverAbajo implements Bloque{

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.moverAbajo(tablero);
    }
}
