package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class BloquePersonalizado extends Conjunto{
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre;
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
