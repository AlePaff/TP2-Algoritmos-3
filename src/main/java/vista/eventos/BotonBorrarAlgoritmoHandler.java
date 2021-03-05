package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;

public class BotonBorrarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonBorrarAlgoritmoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.reiniciarAlgoritmo();
        this.vistaAlgoritmo.update();
    }
}

