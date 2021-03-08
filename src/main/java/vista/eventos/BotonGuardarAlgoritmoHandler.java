package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import modelo.AlgoBlocks;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;

public class BotonGuardarAlgoritmoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private  final VistaAlgoritmo vistaAlgoritmo;
    private final TextField campoNombreAlgoritmo;
    private final VBox contenedor;

    public BotonGuardarAlgoritmoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, TextField campoNombre, VBox contenedor) {
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.campoNombreAlgoritmo = campoNombre;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = this.campoNombreAlgoritmo.getText();
        BloquePersonalizado bloquePersonalizado = this.algoBlocks.guardarAlgoritmo(nombre);

        Button botonBloquePersonalizado = new Button(nombre);
        BotonBloquePersonalizadoHandler algoritmoPersonalizadoHandler = new BotonBloquePersonalizadoHandler(algoBlocks, vistaAlgoritmo, bloquePersonalizado);
        botonBloquePersonalizado.setOnAction(algoritmoPersonalizadoHandler);

        contenedor.getChildren().add(botonBloquePersonalizado);

        this.campoNombreAlgoritmo.clear();

    }
}
