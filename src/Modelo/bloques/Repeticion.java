package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class Repeticion implements Bloque {
    private int repeticiones;
    Bloque bloque;

    public Repeticion(Bloque bloque, int repeticiones) {
        setRepeticiones(repeticiones);
        this.bloque = bloque;
    }

    public void setRepeticiones (int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        for (int i = 0; i < repeticiones; i++)
            bloque.ejecutar(personaje, tablero);
    }
}

