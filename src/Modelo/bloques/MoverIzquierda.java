package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class MoverIzquierda implements Bloque{


    @Override
    public void ejecutar(Personaje personaje, Posicion posicion, Tablero tablero) {
        int xAux = posicion.getPosX();
        int yAux = posicion.getPosY();

        Posicion posAux = new Posicion(xAux,yAux);
        posAux.moverIzquierda();
        posicion.moverPersonajeHacia( personaje,  tablero, posAux);
    }
}
