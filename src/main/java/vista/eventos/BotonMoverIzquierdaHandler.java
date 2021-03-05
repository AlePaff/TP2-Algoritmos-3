package vista.eventos;

import modelo.bloques.MoverIzquierda;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonMoverIzquierdaHandler(AlgoBlocks algoBlocks){
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverIzquierda bloque = new MoverIzquierda();
        this.algoBlocks.agregarBloque(bloque);
    }
}
