package vista;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
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
        for (Bloque bloque : this.algoBlocks.getAlgoritmo()){
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
