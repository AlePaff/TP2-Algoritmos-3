package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;

public class BotonBloquePersonalizadoHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final BloquePersonalizado bloque;

    public BotonBloquePersonalizadoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, BloquePersonalizado bloque){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.bloque = bloque;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.algoBlocks.agregarBloque(bloque);
        //this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }

}
