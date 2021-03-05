package modelo.bloques;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public abstract class Conjunto implements Bloque {

    protected ArrayList<Bloque> bloques = new ArrayList<>();

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public abstract void ejecutar(Personaje personaje, Tablero tablero);

    public abstract void ejecutarInvertido(Personaje personaje, Tablero tablero);

    public int tamanio(){
        return bloques.size();
    }
}