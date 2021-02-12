
public class Personaje {

    private Estado estado = new LapizArriba();

    void dibujar(Bloque bloque) {
        /* ? */
        this.hacerMovimiento(bloque); /* ? */
    }
    public boolean lapizArriba() {
        return true;
    }

    public boolean lapizAbajo() { return false;}
}

    void hacerMovimiento(Bloque bloque) { this.estado.hacerMovimiento(this, bloque); }

    void subirLapiz() {
        this.estado = new LapizArriba();
    }

    void bajarLapiz() {
        this.estado = new LapizAbajo();
    }

