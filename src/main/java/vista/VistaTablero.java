package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.AlgoBlocks;
import modelo.tablero.Posicion;

public class VistaTablero {
    private final AlgoBlocks algoBlocks;
    Canvas canvas;
    double ancho;
    double alto;
    int relacion_horizontal;
    int relacion_vertical;
    int GROSOR = 12;
    VistaPersonaje vistaPersonaje;


    public VistaTablero(AlgoBlocks algoBlocks, Canvas canvasCentral, int relacion_horizontal, int relacion_vertical) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
        this.ancho = canvas.getWidth();
        this.alto = canvas.getHeight();
        this.relacion_horizontal = relacion_horizontal;
        this.relacion_vertical = relacion_vertical;
        this.vistaPersonaje = new VistaPersonaje(algoBlocks, canvasCentral, relacion_horizontal, relacion_vertical);

    }

    public void dibujar(){
        clean();
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        for (Posicion posicion : algoBlocks.getPosicionesDibujadas()){
            canvas.getGraphicsContext2D().fillRect(posicion.getPosX() * relacion_horizontal, posicion.getPosY() * relacion_vertical, GROSOR, GROSOR);
        }
        this.vistaPersonaje.dibujarAvatar();
    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, ancho, alto);
    }

    public void update(){ this.dibujar(); }
}
