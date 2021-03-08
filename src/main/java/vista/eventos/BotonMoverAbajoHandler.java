package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverAbajo;
import vista.VistaAlgoritmo;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverAbajo bloque = new MoverAbajo();
        this.algoBlocks.agregarBloque(bloque);
        bloque.setNombre("abajo");
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }

}
