package vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;

public class VistaAlgoritmo {

    private final AlgoBlocks algoBlocks;
    private final VBox contenedor;


    public VistaAlgoritmo(AlgoBlocks algoBlocks, VBox contenedor) {
        this.algoBlocks = algoBlocks;
        this.contenedor = contenedor;
    }


    public void mostrarBloques() {
        this.clean();
        for (Bloque bloque : this.algoBlocks.getBloques()){
            this.contenedor.getChildren().add(new Button());
        }
    }

    public void clean(){
        this.contenedor.getChildren().clear();
    }

    public void update(){
        this.mostrarBloques();
    }
}
