package vista.eventos;

import Modelo.bloques.MoverDerecha;
import Modelo.bloques.SubirLapiz;
import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonSubirLapizHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final Personaje personaje;


    public BotonSubirLapizHandler(Personaje personaje, VistaPersonaje vistaPersonaje) {
        this.personaje = personaje;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //SubirLapiz bloque = new SubirLapiz();
        //this.algoBlocks.agregarBloque(bloque);
        this.personaje.subirLapiz();
        this.vistaPersonaje.update();

    }
}
