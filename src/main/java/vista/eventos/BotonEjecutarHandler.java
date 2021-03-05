package vista.eventos;

import modelo.AlgoBlocks;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonEjecutarHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;

    public BotonEjecutarHandler(VistaPersonaje vistaPersonaje, AlgoBlocks algoBlocks){
        this.vistaPersonaje = vistaPersonaje;
        this.algoBlocks = algoBlocks;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.ejecutarAlgoritmo();
        this.vistaPersonaje.update();
    }
}

