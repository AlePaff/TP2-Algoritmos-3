package Modelo.bloques;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

import java.util.ArrayList;

public abstract class Conjunto implements Bloque {

    protected ArrayList<Bloque> bloques = new ArrayList<>();

    void agregarBloques(Bloque bloque){
        bloques.add(bloque);
    }

    public abstract void ejecutar(Personaje personaje, Tablero tablero);
}