package modelo.bloques;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public abstract class Conjunto extends Bloque {

    protected ArrayList<Bloque> bloques = new ArrayList<>();

    public ArrayList<Bloque> getBloques() {
        return bloques;
    }

    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public int tamanio(){
        return bloques.size();
    }

    public abstract void ejecutar(Personaje personaje, Tablero tablero);

    public abstract void ejecutarInvertido(Personaje personaje, Tablero tablero);

}