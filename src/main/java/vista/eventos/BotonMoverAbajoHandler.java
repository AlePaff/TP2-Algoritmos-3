package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.MoverAbajo;
import modelo.bloques.MoverDerecha;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks){
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverAbajo bloque = new MoverAbajo();
        this.algoBlocks.agregarBloque(bloque);
    }

}
