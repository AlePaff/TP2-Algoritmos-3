package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;
import vista.VistaTablero;

public class BotonReiniciarJuegoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final VistaTablero vistaTablero;

    public BotonReiniciarJuegoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, VistaTablero vistaTablero) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.vistaTablero = vistaTablero;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        this.algoBlocks.reiniciarJuego();
        this.vistaTablero.update();
        this.vistaAlgoritmo.update();
    }
}
