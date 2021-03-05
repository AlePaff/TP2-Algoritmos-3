package vista;

import modelo.AlgoBlocks;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaPersonaje {

    private final AlgoBlocks algoBlocks;
    Canvas canvas;
    double ancho;
    double alto;
    int RADIO = 10;

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.ancho = canvas.getWidth();
        this.alto = canvas.getHeight();

    }

    public void dibujar(){
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.BLUE);
        canvas.getGraphicsContext2D().fillOval(algoBlocks.getPosicionDelPersonaje().getPosX() , algoBlocks.getPosicionDelPersonaje().getPosY() , RADIO, RADIO);

    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
        canvas.getGraphicsContext2D().fillRect(0, 0, ancho, alto);
    }

    public void update(){ this.dibujar(); }
}
