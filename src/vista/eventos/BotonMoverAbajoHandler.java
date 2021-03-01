package vista.eventos;

import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverIzquierda;
import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaPersonaje vistaPersonaje;

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverAbajo bloque = new MoverAbajo();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();
    }
}
