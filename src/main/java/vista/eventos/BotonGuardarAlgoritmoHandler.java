package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import vista.VistaPersonaje;

public class BotonGuardarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonGuardarAlgoritmoHandler(AlgoBlocks algoBlocks) {
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.ejecutarAlgoritmo();
        //this.vistaPersonaje.update();

    }
}
