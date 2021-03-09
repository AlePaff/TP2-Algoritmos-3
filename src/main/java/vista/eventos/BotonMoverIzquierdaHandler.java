package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverIzquierda;
import vista.VistaAlgoritmo;

public class BotonMoverIzquierdaHandler extends BotonBloqueHandler{
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverIzquierdaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverIzquierda bloque = new MoverIzquierda();
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();
    }
}
