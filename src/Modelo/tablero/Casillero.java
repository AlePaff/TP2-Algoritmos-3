package Modelo.tablero;

public class Casillero {
    private boolean pintado = false;

    public void pintar(){
        pintado = true;
    }

    public boolean estaPintado(){
        return pintado;
    }
}
