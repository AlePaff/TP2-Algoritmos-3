package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.SubirLapiz;
import vista.VistaAlgoritmo;

public class BotonSubirLapizHandler extends BotonBloqueHandler {
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonSubirLapizHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo) {
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SubirLapiz bloque = new SubirLapiz();
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();
    }
}

