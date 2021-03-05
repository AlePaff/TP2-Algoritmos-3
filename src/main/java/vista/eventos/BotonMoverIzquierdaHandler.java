package vista.eventos;

import modelo.bloques.MoverIzquierda;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaPersonaje vistaPersonaje;
    //private final Tablero tablero;

    public BotonMoverIzquierdaHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
      //  this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverIzquierda bloque = new MoverIzquierda();
        this.algoBlocks.agregarBloque(bloque);
        //this.personaje.moverIzquierda(tablero);
        this.vistaPersonaje.update();
    }
}
