package vista.eventos;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.BloquePersonalizado;
import vista.VistaAlgoritmo;
import vista.VistaTablero;

public class BotonReiniciarJuegoHandler extends BotonBloqueHandler {
    private final AlgoBlocks algoBlocks;
    private final VistaAlgoritmo vistaAlgoritmo;
    private final VistaTablero vistaTablero;
    private final VBox contenedor;

    public BotonReiniciarJuegoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, VistaTablero vistaTablero, VBox contenedor) {
        super(algoBlocks, vistaAlgoritmo);
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
        this.vistaTablero = vistaTablero;
        this.contenedor = contenedor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        setEstrategia(new EstrategiaHandleAlgoritmo(algoBlocks));
        this.algoBlocks.reiniciarJuego();
        this.vistaTablero.update();
        this.vistaAlgoritmo.update();
        this.contenedor.getChildren().clear();
    }

    @Override
    public Bloque crearBloque(){
        return new BloquePersonalizado();
    }

}
