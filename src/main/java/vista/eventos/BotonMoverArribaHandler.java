package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverArriba;
import vista.VistaAlgoritmo;

public class BotonMoverArribaHandler extends BotonBloqueHandler {
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverArribaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverArriba bloque = new MoverArriba();
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();

    }
}
