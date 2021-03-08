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
        this.posicion = posicion.moverDerecha(tablero, DISTANCIA_DE_MOVIMIENTO);
        dibujar(tablero);
    }

    public void moverIzquierda(Tablero tablero) {
        this.posicion = posicion.moverIzquierda(tablero,DISTANCIA_DE_MOVIMIENTO);
        dibujar(tablero);
    }

    public void moverArriba(Tablero tablero) {
        this.posicion = posicion.moverArriba(tablero,DISTANCIA_DE_MOVIMIENTO);
        dibujar(tablero);
    }

    public void moverAbajo(Tablero tablero) {
        this.posicion = posicion.moverAbajo(tablero,DISTANCIA_DE_MOVIMIENTO);
        dibujar(tablero);
    }

    private void dibujar(Tablero tablero){

        lapiz.dibujar(tablero, posicion);
    }

    public boolean estaEnPosicion(Posicion posicion) {
        return this.posicion.esIgualA(posicion);
    }

}