package vista;

import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaPersonaje {
    //FALTA RESOLVER IMAGEN PERSONAJE

    private final AlgoBlocks algoBlocks;
    Canvas canvas;

    public VistaPersonaje(AlgoBlocks algoBlocks, Canvas canvasCentral) {
        this.algoBlocks = algoBlocks;
        this.canvas = canvasCentral;
    }

    public void dibujar(){
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
       // canvas.getGraphicsContext2D().fillOval(personaje.getPosicion().getPosX() + 230, personaje.getPosicion().getPosY() + 110, personaje.RADIO, personaje.RADIO);

    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    public void update(){ this.dibujar(); }
}
