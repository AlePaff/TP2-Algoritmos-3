package vista;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.Conjunto;

import java.io.InputStream;


public class VistaAlgoritmo {

    private static final String IMAGEN_TERMINAR = "file:src/main/java/vista/imagenes/terminar.png";
    private final AlgoBlocks algoBlocks;
    private final VBox contenedor;

    public VistaAlgoritmo(AlgoBlocks algoBlocks, VBox contenedor) {
        this.algoBlocks = algoBlocks;
        this.contenedor = contenedor;
    }


    public void mostrarBloques() {
        this.clean();
        for (Bloque bloque: this.algoBlocks.getAlgoritmo()) {
            if (bloque.getNombre() == "repetir" || bloque.getNombre() == "invertir")
                mostrarImagenConjunto((Conjunto) bloque);
            else
                mostrarImagen(bloque);
        }
    }

    public void mostrarImagen(Bloque bloque){
        Image image = new Image("file:src/main/java/vista/imagenes/" + bloque.getNombre() + ".png", 40, 40, false, false);
        this.contenedor.getChildren().add(new ImageView(image));
    }

    public void mostrarImagenConjunto(Conjunto conjunto){
        for(int i = 0; i < conjunto.tamanio(); i++){
            Image image = new Image("file:src/main/java/vista/imagenes/" + conjunto.getBloques().get(i).getNombre() + ".png", 40, 40, false, false);
            this.contenedor.getChildren().add(new ImageView(image));
        }
    }

    public void clean(){
        this.contenedor.getChildren().clear();
    }

    public void update(){
        this.mostrarBloques();
    }
}
