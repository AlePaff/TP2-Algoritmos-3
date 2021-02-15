package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class MoverIzquierda implements Bloque{
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
    personaje.moverIzquierda(tablero);
    }
}
