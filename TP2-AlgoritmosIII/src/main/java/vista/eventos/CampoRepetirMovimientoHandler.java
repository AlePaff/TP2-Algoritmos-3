package vista.eventos;


import Modelo.bloques.MoverDerecha;
import Modelo.bloques.Repeticion;
import Modelo.tablero.AlgoBlocks;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import vista.VistaPersonaje;

public class CampoRepetirMovimientoHandler implements EventHandler<ActionEvent> {
    private final VistaPersonaje vistaPersonaje;
    private final AlgoBlocks algoBlocks;
    private int cantRepeticiones;


    public CampoRepetirMovimientoHandler(AlgoBlocks algoBlocks, VistaPersonaje vistaPersonaje, TextField campoCantRepeticiones){
        this.algoBlocks = algoBlocks;
        this.vistaPersonaje = vistaPersonaje;
        this.cantRepeticiones = Integer.parseInt(campoCantRepeticiones.getText()); //REVISAR EXCEPCIONES DE ESTO
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Repeticion bloque = new Repeticion(cantRepeticiones);
        this.algoBlocks.agregarBloque(bloque);
        this.vistaPersonaje.update();
    }
}
