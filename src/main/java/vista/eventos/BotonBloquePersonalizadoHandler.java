package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;

public class BotonBloquePersonalizadoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonBloquePersonalizadoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BloquePersonalizado bloque = new BloquePersonalizado();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }

}
