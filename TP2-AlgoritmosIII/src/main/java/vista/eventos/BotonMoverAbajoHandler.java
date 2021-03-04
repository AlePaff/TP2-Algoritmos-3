package vista.eventos;

import Modelo.bloques.MoverAbajo;
import Modelo.bloques.MoverIzquierda;
import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import Modelo.tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
    private final Personaje personaje;
    private final VistaPersonaje vistaPersonaje;
    private final Tablero tablero;

    public BotonMoverAbajoHandler(Personaje personaje, VistaPersonaje vistaPersonaje,Tablero tablero){
        this.personaje = personaje;
        this.vistaPersonaje = vistaPersonaje;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        //MoverAbajo bloque = new MoverAbajo();
        //this.algoBlocks.agregarBloque(bloque);
        this.personaje.moverAbajo(tablero);
        this.vistaPersonaje.update();
    }
}
