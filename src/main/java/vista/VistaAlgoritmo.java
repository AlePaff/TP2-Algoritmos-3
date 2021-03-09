package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.Conjunto;
import modelo.personaje.Personaje;
import modelo.tablero.Tablero;

public class VistaAlgoritmo {

    private final AlgoBlocks algoBlocks;
    private final VBox contenedor;
    Conjunto conjunto;

    public VistaAlgoritmo(AlgoBlocks algoBlocks, VBox contenedor) {
        this.algoBlocks = algoBlocks;
        this.contenedor = contenedor;
    }


    public void mostrarBloques() {
        this.clean();
        for (Bloque bloque: this.algoBlocks.getAlgoritmo()) {
            Image image = new Image("file:src/main/java/vista/imagenes/" + bloque.getNombre() + ".png", 40, 40, false, false);
            this.contenedor.getChildren().add(new ImageView(image));
        }
    }

//    public void mostrarImagen(Conjunto conjunto){
  //      for(int i = 0; i == conjunto.tamanio(); i++){
    //        Image image = new Image("file:src/main/java/vista/imagenes/" + conjunto.getBloques().get(i).getNombre() + ".png", 40, 40, false, false);
      //      this.contenedor.getChildren().add(new ImageView(image));
        //}
    //}

    public void clean(){
        this.contenedor.getChildren().clear();
    }

    public void update(){
        this.mostrarBloques();
    }
}
