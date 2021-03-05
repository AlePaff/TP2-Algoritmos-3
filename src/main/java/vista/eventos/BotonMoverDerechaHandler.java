package vista.eventos;

import modelo.bloques.MoverDerecha;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonMoverDerechaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverDerecha bloque = new MoverDerecha();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
