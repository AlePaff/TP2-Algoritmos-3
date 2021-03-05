package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.SubirLapiz;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonSubirLapizHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;


    public BotonSubirLapizHandler(AlgoBlocks algoBlocks) {
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        SubirLapiz bloque = new SubirLapiz();
        this.algoBlocks.agregarBloque(bloque);
    }
}
