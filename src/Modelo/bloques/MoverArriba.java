package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class MoverArriba implements Bloque{

    @Override
    public void ejecutar(Personaje personaje, Posicion posicion, Tablero tablero) {
        int xAux = posicion.getPosX();
        int yAux = posicion.getPosY();
        Posicion posAux = new Posicion(xAux,yAux);

        posAux.moverArriba();
        posicion.moverPersonajeHacia( personaje,  tablero, posAux);
    }
}

