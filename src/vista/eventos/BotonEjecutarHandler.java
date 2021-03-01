package vista.eventos;

import Modelo.tablero.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonEjecutarHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaPersonaje vistaPersonaje;

    public BotonEjecutarHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.ejecutarAlgoritmo();
        this.vistaPersonaje.update();
    }
}

