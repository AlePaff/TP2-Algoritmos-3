package Modelo.bloques;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;

public class BloquePersonalizado extends Conjunto {
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
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
