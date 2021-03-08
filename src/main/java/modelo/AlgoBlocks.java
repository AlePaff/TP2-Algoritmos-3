package modelo;

import modelo.bloques.Bloque;
import modelo.bloques.BloquePersonalizado;
import modelo.excepciones.PosicionFueraDeRangoException;
import modelo.personaje.Personaje;
import modelo.tablero.Posicion;
import modelo.tablero.Tablero;

import java.util.ArrayList;


public class AlgoBlocks {

    private final Tablero tablero;
    private Personaje personaje;
    private final ArrayList<Bloque> algoritmo = new ArrayList<>();
    private static Posicion posicionInicial;
    private static final int BASE_MAPA = 50;
    private static final int ALTURA_MAPA = 50;

    public AlgoBlocks() {
        this.tablero = new Tablero(BASE_MAPA, ALTURA_MAPA);
        posicionInicial = new Posicion(BASE_MAPA / 2, ALTURA_MAPA / 2, tablero);
        this.personaje = new Personaje(posicionInicial);
    }

    public int getAltura(){
        return ALTURA_MAPA;
    }

    public int getBase(){
        return BASE_MAPA;
    }

    public ArrayList<Bloque> getAlgoritmo() {
        return this.algoritmo;
    }

    public Posicion getPosicionDelPersonaje() {
        return personaje.getPosicion();
    }

    public ArrayList<Posicion> getPosicionesDibujadas(){
        return tablero.getPosicionesDibujadas();
    }

    public void agregarBloque(Bloque bloque) {
        algoritmo.add(bloque);
    }

    public void ejecutarAlgoritmo() {
        for (Bloque bloque : algoritmo) {
            try {
                bloque.ejecutar(personaje, tablero);
            } catch (PosicionFueraDeRangoException e) {
                //bloque no se ejecuta
            }
        }
        algoritmo.clear();
    }

    public void reiniciarTablero() {
        tablero.eliminarDibujo();
        this.personaje = new Personaje(posicionInicial);
    }

    public void reiniciarAlgoritmo() {
        algoritmo.clear();
    }

    public BloquePersonalizado guardarAlgoritmo(String nombre) {
        BloquePersonalizado bloque = new BloquePersonalizado();
        bloque.setNombre(nombre);
        bloque.agregarAlgoritmo(this.algoritmo);
        return bloque;
    }
}
