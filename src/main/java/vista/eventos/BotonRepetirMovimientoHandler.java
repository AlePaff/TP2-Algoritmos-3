package vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.Repeticion;
import vista.VistaAlgoritmo;

public class BotonRepetirMovimientoHandler extends BotonBloqueHandler {
    private final int cantRepeticiones;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonRepetirMovimientoHandler(AlgoBlocks algoBlocks, int cantRepeticiones, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks);
        this.cantRepeticiones = cantRepeticiones;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }


    @Override
    public void handle(ActionEvent actionEvent){
        Repeticion bloque = new Repeticion(cantRepeticiones);
        bloque.setNombre("repetir");
        estrategia.agregarADestino(bloque);

        setEstrategia(new EstrategiaHandleConjunto(bloque));

        this.vistaAlgoritmo.update();
    }
}
