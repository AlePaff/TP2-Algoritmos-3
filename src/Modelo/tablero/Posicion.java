package Modelo.tablero;

import Modelo.excepciones.PosicionFueraDeRangoException;

public class Posicion {
    private int posX;
    private int posY;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Posicion(int posX, int posY, Tablero tablero) {
        this.sonCoordenadasValidas(posX, posY, tablero);
        this.posX = posX;
        this.posY = posY;
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

    public boolean esIgualA(Posicion posicion){
        return ((this.posX == posicion.posX) && (this.posY == posicion.posY));
    }

    public Posicion aDerecha(Tablero tablero) {
        return new Posicion(this.posX + DISTANCIA_DE_MOVIMIENTO, this.posY, tablero );
    }

    public Posicion aIzquierda(Tablero tablero) {
        return new Posicion(this.posX - DISTANCIA_DE_MOVIMIENTO, this.posY, tablero );
    }

    public Posicion deArriba(Tablero tablero) {
        return new Posicion(this.posX, this.posY + DISTANCIA_DE_MOVIMIENTO, tablero );
    }
    public Posicion deAbajo(Tablero tablero) {
        return new Posicion(this.posX, this.posY - DISTANCIA_DE_MOVIMIENTO, tablero );
    }
}

