package vista.eventos;

import modelo.personaje.Personaje;
import modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
    private final Personaje personaje;
    private final VistaPersonaje vistaPersonaje;
    private final Tablero tablero;

    public BotonMoverArribaHandler(Personaje personaje, VistaPersonaje vistaPersonaje,Tablero tablero){
        this.personaje = personaje;
        this.vistaPersonaje = vistaPersonaje;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        //MoverArriba bloque = new MoverArriba();
        //this.algoBlocks.agregarBloque(bloque);
        this.personaje.moverArriba(tablero);
        this.vistaPersonaje.update();
    }
}
