package vista;

import Modelo.personaje.Personaje;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaPersonaje {

    private Personaje personaje;
    Canvas canvas;

    public VistaPersonaje(Personaje personaje, Canvas canvasCentral) {
        this.personaje = personaje;
        this.canvas = canvasCentral;
    }

    public void dibujar(){
        this.clean();
        canvas.getGraphicsContext2D().setFill(Color.RED);
        canvas.getGraphicsContext2D().fillOval(personaje.getPosicion().getX() + 230, personaje.getPosicion().getY() + 110, robot.RADIO, robot.RADIO);

    }

    public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }

    //public void update(){ this.dibujar(); }
}
