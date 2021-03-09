package vista;


import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.AlgoBlocks;
import modelo.bloques.*;

import java.io.InputStream;


public class VistaAlgoritmo {

    private static final String RUTA_IMAGENES = "file:src/main/java/vista/imagenes/";
    private static final String EXTENSION = ".png";
    private final AlgoBlocks algoBlocks;
    private final VBox contenedor;

    public VistaAlgoritmo(AlgoBlocks algoBlocks, VBox contenedor) {
        this.algoBlocks = algoBlocks;
        this.contenedor = contenedor;
    }


    public void mostrarBloques() {
        this.clean();
        for (Bloque bloque: this.algoBlocks.getAlgoritmo()) {
            if (bloque.getNombre().equals(new Repeticion(2).getNombre())  || bloque.getNombre().equals(new Repeticion(3).getNombre()) || bloque.getNombre().equals(new InvertirComportamiento().getNombre()) || bloque.getNombre().equals(new BloquePersonalizado().getNombre()))
                mostrarImagenConjunto((Conjunto) bloque);
            else
                mostrarImagen(bloque);
        }
    }

    public void mostrarImagen(Bloque bloque){
        Image image = new Image(RUTA_IMAGENES + bloque.getNombre() + EXTENSION, 40, 40, false, false);
        this.contenedor.getChildren().add(new ImageView(image));
    }

    public void mostrarImagenConjunto(Conjunto conjunto){
        mostrarImagen(conjunto);
        for (int i = 0; i < conjunto.tamanio(); i++){
            mostrarImagen(conjunto.getBloques().get(i));
        }
    }


    public void clean(){
        this.contenedor.getChildren().clear();
    }

    public void update(){
        this.mostrarBloques();
    }
}
