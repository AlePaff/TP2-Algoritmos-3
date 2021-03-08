package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverDerecha;
import vista.VistaAlgoritmo;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
    private final AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonMoverDerechaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverDerecha bloque = new MoverDerecha();
        this.algoBlocks.agregarBloque(bloque);
        bloque.setNombre("derecha");
        this.algoBlocks.agregarNombreBloque(bloque);
        this.vistaAlgoritmo.update();
    }
}
