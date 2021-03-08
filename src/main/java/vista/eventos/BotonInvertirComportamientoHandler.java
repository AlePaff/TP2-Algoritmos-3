package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.InvertirComportamiento;
import vista.VistaAlgoritmo;

public class BotonInvertirComportamientoHandler implements EventHandler<ActionEvent> {
    private final VistaAlgoritmo vistaAlgoritmo;
    private final AlgoBlocks algoBlocks;

    public BotonInvertirComportamientoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        InvertirComportamiento bloque = new InvertirComportamiento();
        bloque.setNombre("invertir");
        this.algoBlocks.agregarBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
