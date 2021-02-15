package Modelo.tablero;

import Modelo.bloques.*;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Bloque> bloques = new ArrayList<>();
    private ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<>();
    private static final int BASE_MINIMA = 12;
    private static final int ALTURA_MINIMA = 12;

    public Tablero(int base, int altura) {
        /* validar tamaño?*/

        for (int i = 0; i < base; i++) {
            ArrayList<Casillero> columna = new ArrayList<>();
            casilleros.add(columna);
            for (int j = 0; j < altura; j++)
                columna.add(new Casillero());
        }
    }
    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public void dibujar(int x, int y) {
        casilleros.get(x).get(y).pintar();
    }
}