package vista.eventos;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final Personaje personaje;
    private final Tablero tablero;

    public BotonMoverDerechaHandler(VistaPersonaje vistaPersonaje,Personaje personaje,Tablero tablero){
        this.vistaPersonaje = vistaPersonaje;
        this.personaje = personaje;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.personaje.moverDerecha(tablero);
        this.vistaPersonaje.update();
    }
}