package modelo.tablero;

import modelo.excepciones.BaseOAlturaNegativosONulosException;

import java.util.ArrayList;

public class Tablero {

    private final int base;
    private final int altura;
    private final ArrayList<Posicion> posicionesDibujadas = new ArrayList<>();

    public Tablero(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new BaseOAlturaNegativosONulosException();
        }
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return this.base;
    }

    public int getAltura() {
        return this.altura;
    }

    public boolean estaPintado(Posicion posicion) {
        for (Posicion posicionDibujada : posicionesDibujadas) {
            if (posicionDibujada.esIgualA(posicion))
                return true;
        }
        return false;
    }

    public void dibujar(Posicion posicion) {
        posicionesDibujadas.add(posicion);
    }

    public void eliminarDibujo(){
        posicionesDibujadas.clear();
     }

    public ArrayList<Posicion> getPosicionesDibujadas() {
        return this.posicionesDibujadas;
    }
}
