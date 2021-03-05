package Modelo.tablero;

import Modelo.bloques.Bloque;
import Modelo.excepciones.PosicionFueraDeRangoException;
import Modelo.personaje.Personaje;

import java.util.ArrayList;

public class AlgoBlocks {

    private Tablero tablero;
    private Personaje personaje;
    private final ArrayList<Bloque> bloques = new ArrayList<>();
    private static Posicion posicionInicial;
    private static final int BASE_MAPA = 250;
    private static final int ALTURA_MAPA = 250;


    public AlgoBlocks() {
        this.tablero = new Tablero(BASE_MAPA, ALTURA_MAPA);
        posicionInicial = new Posicion(BASE_MAPA/2, ALTURA_MAPA/2, tablero);
        this.personaje = new Personaje(posicionInicial);
    }


    public void agregarBloque(Bloque bloque){
        bloques.add(bloque);
    }

    public void ejecutarAlgoritmo() {
        for(Bloque bloque : bloques) {
            try {
                bloque.ejecutar(personaje, tablero);
            } catch (PosicionFueraDeRangoException e) {
                //no habría que hacer nada en particular, solo seguir con el algoritmo
            }
        }
    }

    public void reiniciarTablero(){
        tablero.despintarCasilleros();
        //personaje.setPosicion( new Posicion(BASE_MAPA/2, ALTURA_MAPA/2, tablero));
        this.personaje = new Personaje(posicionInicial);
    }

    public void reiniciarAlgoritmo(){
        bloques.clear();
    }

    public Posicion getPosicionDelPersonaje(){
        return personaje.getPosicion();
    }
}