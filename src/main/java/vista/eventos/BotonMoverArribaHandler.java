package vista.eventos;


import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.MoverArriba;
import vista.VistaAlgoritmo;

public class BotonMoverArribaHandler extends BotonBloqueHandler {

    public BotonMoverArribaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new MoverArriba();
    }
}
