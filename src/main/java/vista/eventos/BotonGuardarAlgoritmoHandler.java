package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

public class BotonGuardarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonGuardarAlgoritmoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = "nombre";
        //debe pedirselo al usuario
        this.algoBlocks.guardarAlgoritmo(nombre);
        this.vistaAlgoritmo.update();

    }
}
