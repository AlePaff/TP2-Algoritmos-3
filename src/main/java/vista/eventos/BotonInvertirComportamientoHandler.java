package vista.eventos;

import modelo.bloques.InvertirComportamiento;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;

public class BotonInvertirComportamientoHandler implements EventHandler<ActionEvent> {
    private final VistaAlgoritmo vistaAlgoritmo;
    private final AlgoBlocks algoBlocks;

    public BotonInvertirComportamientoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        InvertirComportamiento bloque = new InvertirComportamiento();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
