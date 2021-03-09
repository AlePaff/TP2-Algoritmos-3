package vista.eventos;


import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.MoverAbajo;
import vista.VistaAlgoritmo;

public class BotonMoverAbajoHandler extends BotonBloqueHandler {

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new MoverAbajo();
    }
}
