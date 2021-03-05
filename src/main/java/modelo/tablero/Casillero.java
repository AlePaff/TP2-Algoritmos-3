package modelo.tablero;

public class Casillero {
    private boolean pintado = false;

    public void pintar(){
        pintado = true;
    }

    public void despintar(){ pintado = false;}

    public boolean estaPintado(){
        return pintado;
    }
}
