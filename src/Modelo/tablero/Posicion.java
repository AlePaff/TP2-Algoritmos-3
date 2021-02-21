package Modelo.tablero;

import Modelo.excepciones.CoordenadasInvalidasException;
import Modelo.excepciones.PosicionFueraDeRangoException;
import Modelo.personaje.Personaje;

public class Posicion {
    private int posX;
    private int posY;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Posicion(int posX, int posY, Tablero tablero) {

        this.sonCoordenadasValidas(posX, posY, tablero);
        this.posX = posX;
        this.posY = posY;
    }

    private int calcularDistanciaConXeY(int posX, int posY) {
        return Math.max(Math.abs(posX - this.posX), Math.abs(posY - this.posY));
    }

    private void sonCoordenadasValidas(int posX, int posY, Tablero tablero) {
        int base = tablero.getBase();
        int altura = tablero.getAltura();
        if (((posX >= base ) || (posX < 0)) || ((posY >= altura) || (posY < 0))){
            throw new PosicionFueraDeRangoException();
        }

    }

    public void moverAbajo() {
        this.posY = this.posY-DISTANCIA_DE_MOVIMIENTO;
    }
    public void moverArriba() {
        this.posY = this.posY+DISTANCIA_DE_MOVIMIENTO;
    }
    public void moverIzquierda() {
        this.posX = this.posX-DISTANCIA_DE_MOVIMIENTO;
    }
    public void moverDerecha() {
        this.posX = this.posX+DISTANCIA_DE_MOVIMIENTO;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }

    public boolean sonIguales(Posicion posicion){
        return ((this.posX == posicion.posX) && (this.posY == posicion.posY));
    }
}

