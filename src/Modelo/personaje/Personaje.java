package Modelo.personaje;

import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Personaje{

    private Lapiz lapiz = new Lapiz();
    protected Posicion posicion;

    public Personaje(Posicion posicion){
        this.posicion = posicion;
    }

    public void subirLapiz() {
        this.lapiz.setEstrategia(new LapizArriba());
    }

    public void bajarLapiz() {
        this.lapiz.setEstrategia(new LapizAbajo());
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public void moverDerecha(Tablero tablero){
        posicion.moverDerecha();
        dibujar(tablero);
    }

    public void moverIzquierda(Tablero tablero) {
        posicion.moverIzquierda();
        dibujar(tablero);
    }

    public void moverArriba(Tablero tablero) {
        posicion.moverArriba();
        dibujar(tablero);
    }

    public void moverAbajo(Tablero tablero) {
        posicion.moverAbajo();
        dibujar(tablero);
    }

    private void dibujar(Tablero tablero){
        lapiz.dibujar(tablero, posicion);
    }

    public boolean estaEnPosicion(Posicion posicion) {
        return this.posicion.esIgualA(posicion);
    }
}