package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.BajarLapiz;
import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonBajarLapizHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonBajarLapizHandler(AlgoBlocks algoBlocks){
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BajarLapiz bloque = new BajarLapiz();
        this.algoBlocks.agregarBloque(bloque);
    }
}
