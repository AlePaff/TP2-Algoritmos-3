package vista.eventos;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final Personaje personaje;
    private final Tablero tablero;

    public BotonMoverAbajoHandler(VistaPersonaje vistaPersonaje,Personaje personaje,Tablero tablero){
        this.vistaPersonaje = vistaPersonaje;
        this.personaje = personaje;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.personaje.moverAbajo(tablero);
        this.vistaPersonaje.update();
    }
}
