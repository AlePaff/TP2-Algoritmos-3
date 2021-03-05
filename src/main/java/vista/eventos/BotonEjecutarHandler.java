package vista.eventos;

import modelo.personaje.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonEjecutarHandler implements EventHandler<ActionEvent> {
    private final Personaje personaje;
    private final VistaPersonaje vistaPersonaje;

    public BotonEjecutarHandler(Personaje personaje, VistaPersonaje vistaPersonaje){
        this.personaje = personaje;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //this.algoBlocks.ejecutarAlgoritmo();
        this.vistaPersonaje.update();
    }
}

