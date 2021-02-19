package Modelo.tablero;

import Modelo.bloques.*;
import Modelo.excepciones.BaseOAlturaNegativosONulosException;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Bloque> bloques = new ArrayList<>();
    private ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<>();

    public Tablero(int base,int altura) {
        /* validar tamaño, excepcion si alguno es negativo*/
        if (base <=0 || altura <= 0 ){
            throw new BaseOAlturaNegativosONulosException();
        }
        for (int i = 0; i < base; i++) {
            ArrayList<Casillero> columna = new ArrayList<>();
            casilleros.add(columna);
            for (int j = 0; j < altura; j++)
                columna.add(new Casillero());
        }

    }


    public int getBase(){
        return casilleros.size();
    }

    public int getAltura(){
        return casilleros.get(0).size();
    }

    public Casillero getCasillero (int x, int y){
        return casilleros.get(x).get(y);
    }

    public void dibujar(Posicion posicion) {
        int x = posicion.getPosX();
        int y = posicion.getPosY();
        this.getCasillero(x,y).pintar();
    }
}