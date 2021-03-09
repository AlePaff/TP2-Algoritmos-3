package vista.eventos;


import modelo.AlgoBlocks;
import modelo.bloques.BajarLapiz;
import modelo.bloques.Bloque;
import vista.VistaAlgoritmo;

public class BotonBajarLapizHandler extends BotonBloqueHandler {

    public BotonBajarLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new BajarLapiz();
    }
}
