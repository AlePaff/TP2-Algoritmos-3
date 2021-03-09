package vista.eventos;

import javafx.event.ActionEvent;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;
import vista.VistaTablero;

public class BotonReiniciarJuegoHandler extends BotonBloqueHandler {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final VistaTablero vistaTablero;

    public BotonReiniciarJuegoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, VistaTablero vistaTablero) {
        super(algoBlocks, vistaAlgoritmo);
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.vistaTablero = vistaTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        setEstrategia(new EstrategiaHandleAlgoritmo(algoBlocks));
        this.algoBlocks.reiniciarJuego();
        this.vistaTablero.update();
        this.vistaAlgoritmo.update();
    }

    @Override
    public Bloque crearBloque(){
        return new BloquePersonalizado();
    }

}
