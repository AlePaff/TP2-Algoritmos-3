package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;

public class BotonGuardarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final TextField campoNombreAlgoritmo;


    public BotonGuardarAlgoritmoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo,  TextField campoNombreAlgoritmo) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.campoNombreAlgoritmo = campoNombreAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = this.campoNombreAlgoritmo.getText();
        this.algoBlocks.guardarAlgoritmo(nombre);
        this.vistaAlgoritmo.update();
        this.campoNombreAlgoritmo.clear();
    }
}
