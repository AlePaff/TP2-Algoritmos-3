package vista.eventos;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.Conjunto;
import modelo.bloques.InvertirComportamiento;
import modelo.bloques.Repeticion;
import vista.VistaAlgoritmo;

public class BotonRepetirMovimientoHandler extends BotonBloqueHandler {
    private final int cantRepeticiones;
    private VistaAlgoritmo vistaAlgoritmo;


    public BotonRepetirMovimientoHandler(AlgoBlocks algoBlocks, int cantRepeticiones, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
        this.cantRepeticiones = cantRepeticiones;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }


    @Override
    public void handle(ActionEvent actionEvent){
        Conjunto bloque = (Conjunto) crearBloque();
        estrategia.agregarADestino(bloque);

        setEstrategia(new EstrategiaHandleConjunto(bloque));

        this.vistaAlgoritmo.update();
    }

    @Override
    public Bloque crearBloque(){
        return new Repeticion(cantRepeticiones);
    }
}
