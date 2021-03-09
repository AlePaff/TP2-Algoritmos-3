package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverAbajo;
import vista.VistaAlgoritmo;

public class BotonMoverAbajoHandler extends BotonBloqueHandler {
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonMoverAbajoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverAbajo bloque = new MoverAbajo();
        bloque.setNombre("abajo");
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();
    }

}
