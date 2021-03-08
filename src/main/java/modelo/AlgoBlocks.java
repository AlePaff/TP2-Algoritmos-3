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
    private final ArrayList<Bloque> bloques = new ArrayList<>();
    private BloquePersonalizado algoritmo = new BloquePersonalizado();
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

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }

    public void ejecutarAlgoritmo() {
        for (Bloque bloque : bloques) {
            try {
                bloque.ejecutar(personaje, tablero);
            } catch (PosicionFueraDeRangoException e) {
                //no habría que hacer nada en particular, solo seguir con el algoritmo
            }
        }
        bloques.clear();
    }

    public void reiniciarTablero() {
        tablero.eliminarDibujo();
        //personaje.setPosicion( new Posicion(BASE_MAPA/2, ALTURA_MAPA/2, tablero));
        this.personaje = new Personaje(posicionInicial);
    }

    public void reiniciarAlgoritmo() {
        bloques.clear();
    }

    public void guardarAlgoritmo(String nombre) {
        BloquePersonalizado bloque = new BloquePersonalizado();
        bloque.setNombre(nombre);
        bloque.agregarAlgoritmo(this.bloques);
        this.algoritmo = bloque;
    }

    public ArrayList<Bloque> getBloques() {
        return this.bloques;
    }

    public Posicion getPosicionDelPersonaje() {
        return personaje.getPosicion();
    }

    public BloquePersonalizado getAlgoritmo(){
        return this.algoritmo;
    }

    public ArrayList<Posicion> getPosicionesDibujadas(){
        return tablero.getPosicionesDibujadas();
    }
}
