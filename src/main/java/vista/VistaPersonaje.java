package vista;

import modelo.AlgoBlocks;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaPersonaje {

    private final AlgoBlocks algoBlocks;
    Canvas canvas;
    int relacion_horizontal;
    int relacion_vertical;
    int TAMANIO = 40;
    String rutaImagen = "file:src/main/java/vista/imagenes/avatar.jpg";

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral, int relacion_horizontal, int relacion_vertical) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.relacion_horizontal = relacion_horizontal;
        this.relacion_vertical = relacion_vertical;
    }

    public void dibujarAvatar(){
        Image image = new Image(rutaImagen, TAMANIO, TAMANIO,false,false);
        canvas.getGraphicsContext2D().drawImage(image,algoBlocks.getPosicionDelPersonaje().getPosX() * relacion_horizontal,algoBlocks.getPosicionDelPersonaje().getPosY() * relacion_vertical );
    }

}
