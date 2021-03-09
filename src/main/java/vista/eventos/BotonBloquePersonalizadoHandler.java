package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;

public class BotonBloquePersonalizadoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final String nombre;

    public BotonBloquePersonalizadoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, String nombre){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        this.algoBlocks.agregarBloque(algoBlocks.getAlgoritmoGuardado(nombre));
        this.vistaAlgoritmo.update();
    }

}
