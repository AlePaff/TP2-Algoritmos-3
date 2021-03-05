package vista.eventos;

import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonBajarLapizHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final Personaje personaje;

    public BotonBajarLapizHandler(Personaje personaje, VistaPersonaje vistaPersonaje){
        this.personaje = personaje;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        //BajarLapiz bloque = new BajarLapiz();
        this.personaje.bajarLapiz();
        this.vistaPersonaje.update();
    }
}
