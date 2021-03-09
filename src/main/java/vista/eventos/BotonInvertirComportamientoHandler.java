package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.InvertirComportamiento;
import vista.VistaAlgoritmo;

public class BotonInvertirComportamientoHandler extends BotonBloqueHandler {
    private final VistaAlgoritmo vistaAlgoritmo;

    public BotonInvertirComportamientoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        InvertirComportamiento bloque = new InvertirComportamiento();
        bloque.setNombre("invertir");
        estrategia.agregarADestino(bloque);

        setEstrategia( new EstrategiaHandleConjunto(bloque));

        this.vistaAlgoritmo.update();
    }
}
