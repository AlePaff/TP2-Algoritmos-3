package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.SubirLapiz;
import vista.VistaAlgoritmo;

public class BotonSubirLapizHandler extends BotonBloqueHandler {

    public BotonSubirLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo) {
        super(algoBlocks, vistaAlgoritmo);
    }

    @Override
    public Bloque crearBloque(){
        return new SubirLapiz();
    }
}

