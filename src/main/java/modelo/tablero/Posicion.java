package modelo.tablero;

import modelo.excepciones.PosicionFueraDeRangoException;


public class Posicion {
    private final int posX;
    private final int posY;
    private static final int DISTANCIA_DE_MOVIMIENTO = 1;

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

    public Posicion moverDerecha(Tablero tablero) {
        return new Posicion(this.posX + DISTANCIA_DE_MOVIMIENTO, this.posY, tablero );
    }

    public Posicion moverIzquierda(Tablero tablero) {
        return new Posicion(this.posX - DISTANCIA_DE_MOVIMIENTO, this.posY, tablero );
    }

    public Posicion moverArriba(Tablero tablero) {
        return new Posicion(this.posX, this.posY - DISTANCIA_DE_MOVIMIENTO, tablero );
    }

    public Posicion moverAbajo(Tablero tablero) {
        return new Posicion(this.posX, this.posY + DISTANCIA_DE_MOVIMIENTO, tablero );
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

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicion posicion = (Posicion) o;
        return posX == posicion.posX && posY == posicion.posY;
    }
}

