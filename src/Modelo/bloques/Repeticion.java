package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class Repeticion extends Conjunto {
    public int repeticiones;

    public Repeticion( int repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        ejecutarAux(personaje, tablero);
    }
    @Override
    public void ejecutarInvertido(Personaje personaje, Tablero tablero){
        ejecutarAux(personaje, tablero);
    }

    private void ejecutarAux(Personaje personaje, Tablero tablero){
        for (Bloque bloque : bloques) {
            bloque.ejecutar(personaje, tablero);
        }
    }

}

