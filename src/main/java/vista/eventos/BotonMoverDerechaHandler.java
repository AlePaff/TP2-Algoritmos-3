package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.MoverDerecha;
import vista.VistaAlgoritmo;

public class BotonMoverDerechaHandler extends BotonBloqueHandler {
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonMoverDerechaHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        MoverDerecha bloque = new MoverDerecha();
        bloque.setNombre("derecha");
        estrategia.agregarADestino(bloque);
        this.vistaAlgoritmo.update();
    }
}
