package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class MoverIzquierda implements Bloque{
    String nombre = "izquierda";

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.moverIzquierda(tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.moverDerecha(tablero);
    }
}
