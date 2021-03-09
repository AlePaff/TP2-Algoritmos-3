package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public interface Bloque {
    void setNombre(String nombre);

    String getNombre();

    void ejecutar(Personaje personaje, Tablero tablero);

    void ejecutarInvertido(Personaje personaje, Tablero tablero);

}
