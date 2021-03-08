package vista;

import modelo.AlgoBlocks;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class VistaPersonaje {

    private final AlgoBlocks algoBlocks;
    Canvas canvas;
    double ancho;
    double alto;
    int RADIO = 30;

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.ancho = canvas.getWidth();
        this.alto = canvas.getHeight();

    }

    public void dibujar(){
        this.clean();
        Image image = new Image("file:src/main/java/vista/imagenes/avatar.jpg",RADIO,RADIO,false,false);
        //canvas.getGraphicsContext2D().setFill(Color.BLUE);
        canvas.getGraphicsContext2D().drawImage(image,algoBlocks.getPosicionDelPersonaje().getPosX() * 12,algoBlocks.getPosicionDelPersonaje().getPosY() * 12 );
        //canvas.getGraphicsContext2D().fillOval(algoBlocks.getPosicionDelPersonaje().getPosX() * 12 , algoBlocks.getPosicionDelPersonaje().getPosY() * 12, RADIO, RADIO);

    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, ancho, alto);
    }

    public void update(){ this.dibujar(); }
}
