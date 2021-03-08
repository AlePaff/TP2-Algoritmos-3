package modelo.tablero;

import modelo.excepciones.BaseOAlturaNegativosONulosException;
import modelo.excepciones.ElTableroDebeSerCuadradoException;

import java.util.ArrayList;

public class Tablero {

    private final ArrayList<ArrayList<Casillero>> casilleros = new ArrayList<>();
    private final int base;
    private final int altura;
    private final ArrayList<Casillero> dibujo = new ArrayList<>();
    private final ArrayList<Posicion> posiciones = new ArrayList<>();


    public Tablero(int base, int altura) {
        if (base <= 0 || altura <= 0) {
            throw new BaseOAlturaNegativosONulosException();
        }
        if (base != altura) {
            throw new ElTableroDebeSerCuadradoException();
        }
        this.base = base;
        this.altura = altura;

        for (int i = 0; i < base; i++) {
            ArrayList<Casillero> columna = new ArrayList<>();
            casilleros.add(columna);
            for (int j = 0; j < altura; j++)
                columna.add(new Casillero());
        }
    }

    public int getBase() {
        return this.base;
    }

    public int getAltura() {
        return this.altura;
    }

    public Casillero getCasillero(int x, int y){
        return casilleros.get(x).get(y);
    }

    public boolean estaPintado(Posicion posicion){
        return getCasillero(posicion.getPosX(), posicion.getPosY()).estaPintado();
    }

    public void dibujar(Posicion posicion) {
        Casillero casillero = getCasillero(posicion.getPosX(), posicion.getPosY());
        casillero.pintar();
        dibujo.add(casillero);
        posiciones.add(posicion);

    }
    private void despintarCasilleros(){
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < altura; j++){
                Casillero casillero = this.getCasillero(i,j);
                casillero.despintar();
            }
        }
    }

    public void eliminarDibujo(){
        this.despintarCasilleros();
        this.eliminarPosiciones();
        dibujo.clear();
    }
    public void eliminarPosiciones(){
        posiciones.clear();
    }

    public ArrayList<Posicion> getPosicionesDibujadas() {
        return this.posiciones;
    }
}
