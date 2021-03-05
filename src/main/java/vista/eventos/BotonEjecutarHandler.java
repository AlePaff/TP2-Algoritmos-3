package vista.eventos;

import modelo.AlgoBlocks;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonEjecutarHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonEjecutarHandler(VistaPersonaje vistaPersonaje, AlgoBlocks algoBlocks,VistaAlgoritmo vistaAlgoritmo){
        this.vistaPersonaje = vistaPersonaje;
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.ejecutarAlgoritmo();
        this.vistaAlgoritmo.update();
        this.vistaPersonaje.update();
    }
}

