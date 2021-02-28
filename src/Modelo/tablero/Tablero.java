package Modelo.tablero;

import Modelo.bloques.*;
import Modelo.excepciones.BaseOAlturaNegativosONulosException;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Bloque> bloques = new ArrayList<>();
    private ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<>();

    public Tablero(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new BaseOAlturaNegativosONulosException();
        }
        for (int i = 0; i < base; i++) {
            ArrayList<Casillero> columna = new ArrayList<>();
            casilleros.add(columna);
            for (int j = 0; j < altura; j++)
                columna.add(new Casillero());
        }

    }

    public int getBase() {
        return casilleros.size();
    }

    public int getAltura() {
        return casilleros.get(0).size();
    }

    public Casillero getCasillero(int x, int y){
        return casilleros.get(x).get(y);
    }

    public boolean estaPintado(Posicion posicion){
        return getCasillero(posicion.getPosX(), posicion.getPosY()).estaPintado();
    }

    public void dibujar(Posicion posicion) {
        getCasillero(posicion.getPosX(), posicion.getPosY()).pintar();
    }
}