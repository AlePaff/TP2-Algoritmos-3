package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.AlgoBlocks;

public class VistaAlgoritmo {

    private final AlgoBlocks algoBlocks;
    private final Canvas canvas;
    private final double ancho;
    private final double alto;


    public VistaAlgoritmo(AlgoBlocks algoBlocks, Canvas canvas) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvas;
        this.ancho = canvas.getWidth();
        this.alto = canvas.getHeight();
    }


    public void mostrarBloques() {
        this.clean();

    }

    public void clean(){
        canvas.getGraphicsContext2D().setFill(Color.LIGHTGRAY);
        canvas.getGraphicsContext2D().fillRect(0, 0, ancho, alto);
    }

    public void update(){
        this.mostrarBloques();
    }
}
