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
    static final String RUTA_IMAGEN_LAPIZ_ARRIBA = "file:src/main/java/vista/imagenes/avatar.jpg";
    static final String RUTA_IMAGEN_LAPIZ_ABAJO = "file:src/main/java/vista/imagenes/avatar.jpg";

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral, int relacion_horizontal, int relacion_vertical) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.relacion_horizontal = relacion_horizontal;
        this.relacion_vertical = relacion_vertical;
    }

    public void dibujarAvatar(){
        String ruta_imagen = imagenAvatar();

        Image image = new Image(ruta_imagen, TAMANIO, TAMANIO,false,false);
        canvas.getGraphicsContext2D().drawImage(image,algoBlocks.getPosicionDelPersonaje().getPosX() * relacion_horizontal,algoBlocks.getPosicionDelPersonaje().getPosY() * relacion_vertical );
    }

    private String imagenAvatar() {
        if (algoBlocks.LapizLevantado()){
            return RUTA_IMAGEN_LAPIZ_ARRIBA;
        }
        return RUTA_IMAGEN_LAPIZ_ABAJO;
    }

}
