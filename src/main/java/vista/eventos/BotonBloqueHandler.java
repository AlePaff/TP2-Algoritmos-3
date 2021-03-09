package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.AlgoBlocks;


public abstract class BotonBloqueHandler implements EventHandler<ActionEvent> {
    public static EstrategiaHandle estrategia;

    public BotonBloqueHandler(AlgoBlocks algoblocks){
         estrategia = new EstrategiaHandleAlgoritmo(algoblocks);
    }

    public static void setEstrategia(EstrategiaHandle estrategiaHandle){
        estrategia = estrategiaHandle;
    }

    abstract public void handle(ActionEvent actionEvent);

}
