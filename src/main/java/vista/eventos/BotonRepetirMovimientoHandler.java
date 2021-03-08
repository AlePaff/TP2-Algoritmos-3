package vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.Repeticion;
import vista.VistaAlgoritmo;

public class BotonRepetirMovimientoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final int cantRepeticiones;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonRepetirMovimientoHandler(AlgoBlocks algoBlocks, int cantRepeticiones, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.cantRepeticiones = cantRepeticiones;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }


    @Override
    public void handle(ActionEvent actionEvent){
        Repeticion bloque = new Repeticion(cantRepeticiones);
        bloque.setNombre("repetir");
        this.algoBlocks.agregarBloque(bloque);
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
