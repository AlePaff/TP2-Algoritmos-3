package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;
import vista.VistaTablero;

public class BotonEjecutarHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;
    private VistaTablero vistaTablero;

    public BotonEjecutarHandler(AlgoBlocks algoBlocks,VistaAlgoritmo vistaAlgoritmo, VistaTablero vistaTablero){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.vistaTablero = vistaTablero;


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.ejecutarAlgoritmo();
        this.vistaAlgoritmo.update();
        this.vistaTablero.update();
    }
}

