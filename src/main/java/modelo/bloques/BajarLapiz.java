package modelo.bloques;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class BajarLapiz implements Bloque{
    String nombre = "lapizAbajo";

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    @Override
    public void ejecutar(Personaje personaje, Tablero tablero) {
        personaje.bajarLapiz();
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        personaje.subirLapiz();
    }
}
