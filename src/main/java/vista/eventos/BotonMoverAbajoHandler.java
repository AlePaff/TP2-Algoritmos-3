package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.MoverAbajo;
import modelo.bloques.MoverDerecha;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverAbajo bloque = new MoverAbajo();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }

}
