package vista.eventos;


import Modelo.bloques.MoverDerecha;
import Modelo.bloques.Repeticion;
import Modelo.tablero.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaPersonaje;

public class BotonRepetirMovimientoHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;


    public BotonRepetirMovimientoHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        int cantRepeticiones = 2; //Puse esto para que compile
        Repeticion bloque = new Repeticion(cantRepeticiones); //FALTA TEMA CANTIDAD REPETICIONES
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();
    }
}
