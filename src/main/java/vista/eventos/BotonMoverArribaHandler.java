package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverArriba;
import vista.VistaAlgoritmo;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverArribaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverArriba bloque = new MoverArriba();
        this.algoBlocks.agregarBloque(bloque);
        bloque.setNombre("arriba");
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();

    }
}
