package Modelo.tablero;

import Modelo.excepciones.CoordenadasInvalidasException;
import Modelo.personaje.Personaje;

public class Posicion {
    private int posX;
    private int posY;
    protected static final int DISTANCIA_DE_MOVIMIENTO = 1;

    public Posicion(int posX, int posY) {

        if (!this.sonCoordenadasValidas(posX, posY)) {
            throw new CoordenadasInvalidasException();
        }
        this.posX = posX;
        this.posY = posY;
    }

    public void moverPersonajeHacia(Personaje personaje, Tablero tablero, Posicion destino) {
        destino.moverUnidadConXeY(personaje, tablero, this.posX, this.posY);
    }

    private void moverUnidadConXeY(Personaje personaje, Tablero tablero, int xDeOrigen, int yDeOrigen) {
        tablero.moverUnidadDesdeHasta(personaje, yDeOrigen, xDeOrigen, this.posY, this.posX);
    }
    public void descolocarColocable(Tablero tablero) {
        tablero.descolocarColocable(this.posY, this.posX);
    }

    public int calcularDistanciaA(Posicion posicion) {
        return posicion.calcularDistanciaConXeY(this.posX, this.posY);
    }

    private int calcularDistanciaConXeY(int posX, int posY) {
        return max(abs(posX - this.posX), abs(posY - this.posY));
    }

    private boolean esDistanciaValida(int distancia) {
        return distancia > 0;
    }

    private boolean sonCoordenadasValidas(int posX, int posY) {
        return (posX >= 0 && posY >= 0);
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
}

