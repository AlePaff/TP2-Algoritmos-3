package Modelo.bloques;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

import java.util.ArrayList;

public abstract class Conjunto implements Bloque {

    protected ArrayList<Bloque> bloques = new ArrayList<>();

    public void agregarBloques(Bloque bloque){
        bloques.add(bloque);
    }

    public abstract void ejecutar(Movimiento movimiento, Personaje personaje, Tablero tablero);
}