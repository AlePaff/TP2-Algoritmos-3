package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public class Personaje{

    private final Lapiz lapiz = new Lapiz();
    protected Posicion posicion;
    public final int RADIO = 8;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 10;


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
        for (int i = 1; i <= DISTANCIA_DE_MOVIMIENTO; i++) {
            this.posicion = posicion.moverDerecha(tablero, 1);
            dibujar(tablero);
        }
    }

    public void moverIzquierda(Tablero tablero) {
        for (int i = 1; i <= DISTANCIA_DE_MOVIMIENTO; i++) {
            this.posicion = posicion.moverIzquierda(tablero, 1);
            dibujar(tablero);
        }
    }

    public void moverArriba(Tablero tablero) {
        for (int i = 1; i <= DISTANCIA_DE_MOVIMIENTO; i++) {
            this.posicion = posicion.moverArriba(tablero, 1);
            dibujar(tablero);
        }
    }

    public void moverAbajo(Tablero tablero) {
        for (int i = 1; i <= DISTANCIA_DE_MOVIMIENTO; i++) {
            this.posicion = posicion.moverAbajo(tablero, 1);
            dibujar(tablero);
        }
    }

    private void dibujar(Tablero tablero){
        lapiz.dibujar(tablero, posicion);
    }

    public boolean estaEnPosicion(Posicion posicion) {
        return this.posicion.esIgualA(posicion);
    }

}