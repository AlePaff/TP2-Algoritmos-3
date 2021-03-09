package vista.eventos;


import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.MoverIzquierda;
import vista.VistaAlgoritmo;

public class BotonMoverIzquierdaHandler extends BotonBloqueHandler{

    public BotonMoverIzquierdaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new MoverIzquierda();
    }
}
