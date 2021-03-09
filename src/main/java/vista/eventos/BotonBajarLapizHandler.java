package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.BajarLapiz;
import vista.VistaAlgoritmo;

public class BotonBajarLapizHandler extends BotonBloqueHandler {
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonBajarLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BajarLapiz bloque = new BajarLapiz();
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();
    }
}
