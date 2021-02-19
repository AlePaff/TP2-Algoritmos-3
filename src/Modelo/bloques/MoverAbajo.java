package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class MoverAbajo implements Bloque{

    @Override
    public void ejecutar(Regla regla, Personaje personaje, Tablero tablero) {
        regla.moverseHaciaAbajo(personaje,tablero);
    }
}
