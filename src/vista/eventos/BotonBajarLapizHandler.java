package vista.eventos;

import Modelo.bloques.BajarLapiz;
import Modelo.bloques.MoverDerecha;
import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonBajarLapizHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;

    public BotonBajarLapizHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BajarLapiz bloque = new BajarLapiz();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();
    }
}
