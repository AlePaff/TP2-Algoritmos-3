package Modelo.personaje;

import Modelo.excepciones.PosicionFueraDeRangoException;
import Modelo.tablero.Posicion;
import Modelo.tablero.Tablero;

public class Personaje{

    private EstadoLapiz lapiz = new LapizArriba();
    protected Posicion posicion;
    protected Tablero tablero;

    public Personaje(int x, int y){
        //int base = tablero.getBase();
        //int altura = tablero.getAltura();
        //if (x > base || y > altura){
          //  throw new PosicionFueraDeRangoException();
        //}
        posicion = new Posicion(x, y);
    }
    public Personaje(){

        posicion = new Posicion(0,0);
    }

    public void subirLapiz() {
        this.lapiz = new LapizArriba();
    }

    public void bajarLapiz() {
        this.lapiz = new LapizAbajo();
    }

    public boolean lapizLevantado(){
        return lapiz instanceof LapizArriba;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    public void moverDerecha(Tablero tablero){
        posicion.moverDerecha();
        lapiz.dibujar(tablero, posicion.getPosX(), posicion.getPosY());
    }

    public void moverIzquierda(Tablero tablero) {
        posicion.moverIzquierda();
        lapiz.dibujar(tablero, posicion.getPosX(), posicion.getPosY());
    }

    public void moverArriba(Tablero tablero) {
        posicion.moverArriba();
        lapiz.dibujar(tablero, posicion.getPosX(), posicion.getPosY());
    }

    public void moverAbajo(Tablero tablero) {
        posicion.moverAbajo();
        lapiz.dibujar(tablero, posicion.getPosX(), posicion.getPosY());
    }
}
