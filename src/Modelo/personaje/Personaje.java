package Modelo.personaje;

import Modelo.bloques.Bloque;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Personaje{

    private EstadoLapiz estado = new LapizArriba();
    protected Posicion posicion;

    void hacerMovimiento(Bloque bloque, Tablero tablero) {
        this.estado.hacerMovimiento(this, bloque, this.posicion, tablero);
    }

    public void subirLapiz() {
        this.estado = new LapizArriba();
    }

    public void bajarLapiz() {
        this.estado = new LapizAbajo();
    }

    void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

}
