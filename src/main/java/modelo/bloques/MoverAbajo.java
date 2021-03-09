package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class MoverAbajo implements Bloque{
    String nombre = "abajo";

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.moverAbajo(tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.moverArriba(tablero);
    }
}
