package modelo.personaje;

import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

public class Lapiz {

    private EstrategiaLapiz estrategia;

    public Lapiz(){
        this.estrategia = new LapizArriba();
    }

    public void setEstrategia(EstrategiaLapiz estrategia){
        this.estrategia = estrategia;
    }

    public void dibujar(Tablero tablero, Posicion posicion){
        this.estrategia.dibujar(tablero, posicion);
    }

    public String getNombreEstrategia() {
        return estrategia.getNombre();
    }
}
