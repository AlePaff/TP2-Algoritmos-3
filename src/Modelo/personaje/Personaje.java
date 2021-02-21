package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Personaje{

    private Lapiz lapiz = new Lapiz();
    protected Posicion posicion;
    protected Tablero tablero;

    public Personaje(Posicion posicion){
        this.posicion = posicion;
    }

    public void subirLapiz() {
        this.lapiz.LapizArriba();
    }

    public void bajarLapiz() {
        this.lapiz.LapizAbajo();
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public void moverDerecha(Tablero tablero){
        posicion.moverDerecha();
        lapiz.dibujar(tablero, posicion);
    }

    public void moverIzquierda(Tablero tablero) {
        posicion.moverIzquierda();
        lapiz.dibujar(tablero, posicion);
    }

    public void moverArriba(Tablero tablero) {
        posicion.moverArriba();
        lapiz.dibujar(tablero, posicion);
    }

    public void moverAbajo(Tablero tablero) {
        posicion.moverAbajo();
        lapiz.dibujar(tablero, posicion);
    }
}
