package Modelo.bloques;

import Modelo.excepciones.RepeticionesNegativasException;
import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class Repeticion extends Conjunto {
    public int repeticiones;

    public Repeticion( int repeticiones) {
        setRepeticiones(repeticiones);
    }

    public void setRepeticiones(int repeticiones) {
        if (repeticiones < 0)
            throw new RepeticionesNegativasException();
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero){
        for (Bloque bloque : bloques)
            bloque.ejecutar(personaje, tablero);
    }
    @Override
    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        for (Bloque bloque : bloques)
            bloque.ejecutarInvertido(personaje, tablero);
    }
}

