package vista.eventos;

import modelo.AlgoBlocks;
import modelo.bloques.MoverArriba;
import modelo.bloques.MoverDerecha;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;

    public BotonMoverArribaHandler(AlgoBlocks algoBlocks){
        this.algoBlocks = algoBlocks;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverArriba bloque = new MoverArriba();
        this.algoBlocks.agregarBloque(bloque);
    }
}
