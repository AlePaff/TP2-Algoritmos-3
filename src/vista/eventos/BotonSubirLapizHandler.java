package vista.eventos;

import Modelo.bloques.MoverDerecha;
import Modelo.bloques.SubirLapiz;
import Modelo.tablero.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonSubirLapizHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;

    public BotonSubirLapizHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje) {
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SubirLapiz bloque = new SubirLapiz();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();

    }
}
