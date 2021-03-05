package vista.eventos;

import modelo.bloques.MoverDerecha;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonMoverDerechaHandler(AlgoBlocks algoBlocks){
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverDerecha bloque = new MoverDerecha();
        this.algoBlocks.agregarBloque(bloque);
    }
}
