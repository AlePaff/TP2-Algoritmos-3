package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public abstract class Bloque {
    private String nombre;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract void ejecutar(Personaje personaje, Tablero tablero);

    public abstract void ejecutarInvertido(Personaje personaje, Tablero tablero);

}
