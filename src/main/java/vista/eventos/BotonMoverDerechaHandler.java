package vista.eventos;


import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.MoverDerecha;
import vista.VistaAlgoritmo;

public class BotonMoverDerechaHandler extends BotonBloqueHandler {

    public BotonMoverDerechaHandler(AlgoBlocks algoblocks, VistaAlgoritmo vistaAlgoritmo) {
        super(algoblocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new MoverDerecha();
    }
}
