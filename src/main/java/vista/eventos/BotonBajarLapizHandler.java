package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.BajarLapiz;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

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
        this.vistaAlgoritmo.update();
    }
}
