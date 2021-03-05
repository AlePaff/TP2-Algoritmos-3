package vista.eventos;

import modelo.bloques.InvertirComportamiento;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonInvertirComportamientoHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;

    public BotonInvertirComportamientoHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        InvertirComportamiento bloque = new InvertirComportamiento(); //chequear que esto está bien así
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();
    }
}
