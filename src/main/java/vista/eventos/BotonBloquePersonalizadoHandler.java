package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;

public class BotonBloquePersonalizadoHandler extends BotonBloqueHandler {
    private final VistaAlgoritmo vistaAlgoritmo;
    private final BloquePersonalizado bloque;

    public BotonBloquePersonalizadoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, BloquePersonalizado bloque){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.bloque = bloque;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        estrategia.agregarADestino(bloque);
        //this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }

}
