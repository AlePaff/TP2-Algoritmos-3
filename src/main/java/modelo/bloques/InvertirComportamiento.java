package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class InvertirComportamiento extends Conjunto {
    private String nombre;

    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getNombre(){ return nombre; }

    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        for (Bloque bloque : bloques) {
            bloque.ejecutarInvertido(personaje, tablero);
        }
    }

    @Override
    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        for (Bloque bloque : bloques) {
            bloque.ejecutar(personaje, tablero);
        }
    }
}