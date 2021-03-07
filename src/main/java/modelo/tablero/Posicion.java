package modelo.tablero;

import modelo.excepciones.PosicionFueraDeRangoException;

public class Posicion {
    private final int posX;
    private final int posY;

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

    public Posicion moverDerecha(Tablero tablero, int distancia) {
        return new Posicion(this.posX + distancia, this.posY, tablero );
    }

    public Posicion moverIzquierda(Tablero tablero, int distancia) {
        return new Posicion(this.posX - distancia, this.posY, tablero );
    }

    public Posicion moverArriba(Tablero tablero, int distancia) {
        return new Posicion(this.posX, this.posY - distancia, tablero );
    }
    public Posicion moverAbajo(Tablero tablero, int distancia) {
        return new Posicion(this.posX, this.posY + distancia, tablero );
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
}

