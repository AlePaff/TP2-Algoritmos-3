package Modelo.tablero;

import Modelo.bloques.*;
import Modelo.personaje.Personaje;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Bloque> bloques = new ArrayList<>();
    private ArrayList<Casillero> casilleros = new ArrayList<>();
    private int base;
    private int altura;
    private static final int BASE_MINIMA = 12;
    private static final int ALTURA_MINIMA = 12;

    public Tablero(int base, int altura) {
        /* validar tamaño?*/

        this.casilleros = new ArrayList<>();
        this.base = base;
        this.altura = altura;
        this.agregarCasilleros();
    }
    void agregarBloqueDerecho(){
        bloques.add(new MoverDerecha());
    }
    void agregarBloqueIzquierdo(){
        bloques.add(new MoverIzquierda());
    }
    void agregarBloqueArriba(){bloques.add(new MoverArriba());}
    void agregarBloqueAbajo(){
        bloques.add(new MoverAbajo());
    }
    void agregarBloqueSubirLapiz(){
        bloques.add(new SubirLapiz());
    }
    void agregarBloqueBajarLapiz(){
        bloques.add(new BajarLapiz());
    }
    void agregarBloqueInvertirComportamiento(){
        bloques.add(new InvertirComportamiento());
    }
    void agregarBloquePersonalizado(){
        bloques.add(new BloquePersonalizado());
    }
    void agregarBloqueRepetir(){
        bloques.add(new BloqueRepetir());
    }


    public void moverUnidadDesdeHasta(Personaje personaje, int filaOrigen, int columnaOrigen, int filaDestino, int columnaDestino) {
        Casillero casilleroOrigen = this.buscarCasillero(filaOrigen, columnaOrigen);
        Casillero casilleroDestino = this.buscarCasillero(filaDestino, columnaDestino);
        casilleroDestino.colocar(personaje);
        personaje.setPosicion(new Posicion(columnaDestino, filaDestino));
        casilleroOrigen.desocupar();
    }
}
    private void agregarCasilleros() {
        for (int i = 0; i < this.altura; i++) {
            for (int j = 0; j < this.base; j++) {
                Casillero casillero = new Casillero();
                this.casilleros.add(casillero);
            }
        }
    }

}