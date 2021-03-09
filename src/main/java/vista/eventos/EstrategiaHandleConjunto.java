package vista.eventos;

import modelo.bloques.Bloque;
import modelo.bloques.Conjunto;

public class EstrategiaHandleConjunto implements EstrategiaHandle {
    private final Conjunto bloqueConjunto;

    public EstrategiaHandleConjunto(Conjunto bloque){
        bloqueConjunto = bloque;
    }

    @Override
    public void agregarADestino(Bloque bloque) {
        bloqueConjunto.agregarBloque(bloque);
    }

}
