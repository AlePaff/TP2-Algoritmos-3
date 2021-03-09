package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import vista.VistaAlgoritmo;


public abstract class BotonBloqueHandler implements EventHandler<ActionEvent> {
    public static EstrategiaHandle estrategia;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonBloqueHandler(AlgoBlocks algoblocks, VistaAlgoritmo vistaAlgoritmo){
         estrategia = new EstrategiaHandleAlgoritmo(algoblocks);
         this.vistaAlgoritmo = vistaAlgoritmo;
    }

    public static void setEstrategia(EstrategiaHandle estrategiaHandle){
        estrategia = estrategiaHandle;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        estrategia.agregarADestino( crearBloque());
        this.vistaAlgoritmo.update();
    }

    abstract Bloque crearBloque();
}
