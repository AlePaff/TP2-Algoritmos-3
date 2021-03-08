package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverIzquierda;
import vista.VistaAlgoritmo;

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
        bloque.setNombre("izquierda");
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
