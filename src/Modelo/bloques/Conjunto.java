package Modelo.bloques;
import java.util.ArrayList;

public abstract class Conjunto implements Bloque {

    protected ArrayList<Bloque> bloques = new ArrayList<>();

    void agregarBloques(Bloque bloque){
        bloques.add(bloque);
    }

    void ejecutar() {

    }

}