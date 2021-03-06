package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.AlgoBlocks;
import vista.VistaAlgoritmo;
import vista.VistaPersonaje;

import java.awt.*;

public class BotonGuardarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;
    private final javafx.scene.control.TextField campoNombreAlgoritmo;

    public BotonGuardarAlgoritmoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, TextField campoNombre) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.campoNombreAlgoritmo = campoNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = this.campoNombreAlgoritmo.getText();
        this.algoBlocks.guardarAlgoritmo(nombre);
        this.vistaAlgoritmo.update();
        this.campoNombreAlgoritmo.clear();

    }
}
