package modelo.tablero;

import modelo.excepciones.BaseOAlturaNegativosONulosException;
import modelo.excepciones.ElTableroDebeSerCuadradoException;

import java.util.ArrayList;

public class Tablero {

    private final int base;
    private final int altura;
    private final ArrayList<Posicion> posicionesDibujadas = new ArrayList<>();

    public Tablero(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new BaseOAlturaNegativosONulosException();
        }
        if (base != altura) {
            throw new ElTableroDebeSerCuadradoException();
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

    public boolean estaPintado(Posicion posicion){
        return posicionesDibujadas.contains(posicion);
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
