package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.BajarLapiz;
import vista.VistaAlgoritmo;

public class BotonBajarLapizHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonBajarLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BajarLapiz bloque = new BajarLapiz();
        this.algoBlocks.agregarBloque(bloque);
        bloque.setNombre("lapizAbajo");
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
