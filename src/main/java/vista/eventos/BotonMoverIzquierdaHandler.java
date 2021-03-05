package vista.eventos;

import modelo.bloques.MoverIzquierda;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverIzquierdaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverIzquierda bloque = new MoverIzquierda();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
