package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.MoverArriba;
import modelo.bloques.MoverDerecha;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverArribaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverArriba bloque = new MoverArriba();
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();

    }
}
