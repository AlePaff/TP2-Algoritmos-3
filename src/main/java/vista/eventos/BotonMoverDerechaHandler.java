package vista.eventos;

import modelo.bloques.MoverDerecha;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;
    //private final Tablero tablero;

    public BotonMoverDerechaHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
       // this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverDerecha bloque = new MoverDerecha(); //chequear que esto está bien así
        this.algoBlocks.agregarBloque(bloque);
        //this.personaje.moverDerecha(tablero);
        this.vistaPersonaje.update();
    }
}
