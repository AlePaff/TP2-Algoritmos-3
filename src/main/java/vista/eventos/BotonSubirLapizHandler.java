package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.SubirLapiz;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

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
        this.algoBlocks.agregarBloque(bloque);
    }
}
