package vista.eventos;

import Modelo.personaje.Personaje;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonLevantarLapizHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final Personaje personaje;


    public BotonLevantarLapizHandler(VistaPersonaje vistaPersonaje,Personaje personaje){
        this.vistaPersonaje = vistaPersonaje;
        this.personaje = personaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.personaje.subirLapiz();
        this.vistaPersonaje.update();
    }
}
