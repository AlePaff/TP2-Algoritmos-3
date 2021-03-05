package vista.eventos;


import modelo.bloques.Repeticion;
import modelo.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonRepetirMovimientoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final int cantRepeticiones;


    public BotonRepetirMovimientoHandler(AlgoBlocks algoBlocks, int cantRepeticiones){
        this.algoBlocks = algoBlocks;
        this.cantRepeticiones = cantRepeticiones;

    }


    @Override
    public void handle(ActionEvent actionEvent){
        Repeticion bloque = new Repeticion(cantRepeticiones);
        this.algoBlocks.agregarBloque(bloque);
    }
}
