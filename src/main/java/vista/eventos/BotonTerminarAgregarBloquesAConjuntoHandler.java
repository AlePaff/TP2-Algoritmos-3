package vista.eventos;

import javafx.event.ActionEvent;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;

public class BotonTerminarAgregarBloquesAConjuntoHandler extends BotonBloqueHandler {
    private AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonTerminarAgregarBloquesAConjuntoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        setEstrategia( new EstrategiaHandleAlgoritmo(algoBlocks));
        this.vistaAlgoritmo.update();
    }
}
