package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.SubirLapiz;
import vista.VistaAlgoritmo;

public class BotonSubirLapizHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonSubirLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SubirLapiz bloque = new SubirLapiz();
        bloque.setNombre("lapizArriba");
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
