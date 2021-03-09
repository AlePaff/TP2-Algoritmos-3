package vista;

import modelo.AlgoBlocks;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public class VistaPersonaje {

    private final AlgoBlocks algoBlocks;
    Canvas canvas;
    int relacion_horizontal;
    int relacion_vertical;
    int TAMANIO = 70;
    static final String RUTA_IMAGEN = "file:src/main/java/vista/imagenes/avatar";
    private static final String EXTENSION = ".png";

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral, int relacion_horizontal, int relacion_vertical) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.relacion_horizontal = relacion_horizontal;
        this.relacion_vertical = relacion_vertical;
    }

    public void dibujarAvatar(){
        String nombre_imagen = RUTA_IMAGEN + algoBlocks.getNombreEstrategiaLapiz() + EXTENSION;

        Image image = new Image(nombre_imagen, TAMANIO, TAMANIO,false,false);
        canvas.getGraphicsContext2D().drawImage(image,algoBlocks.getPosicionDelPersonaje().getPosX() * relacion_horizontal,algoBlocks.getPosicionDelPersonaje().getPosY() * relacion_vertical );
    }
}
