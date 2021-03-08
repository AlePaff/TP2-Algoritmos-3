package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

import java.util.ArrayList;

public class BloquePersonalizado extends Conjunto {
    public void agregarAlgoritmo(ArrayList<Bloque> algoritmo){
        bloques.addAll(algoritmo);
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        for (Bloque bloque : bloques)
            bloque.ejecutar(personaje, tablero);
    }

    @Override
    public void ejecutarInvertido(Personaje personaje, Tablero tablero){
        for (Bloque bloque : bloques)
            bloque.ejecutarInvertido(personaje, tablero);
    }
}
