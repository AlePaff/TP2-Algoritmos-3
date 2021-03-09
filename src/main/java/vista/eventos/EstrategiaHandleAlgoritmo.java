package vista.eventos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;

public class EstrategiaHandleAlgoritmo implements EstrategiaHandle {
    public AlgoBlocks algoblocks;

    public EstrategiaHandleAlgoritmo(AlgoBlocks algoBlocks){
        this.algoblocks = algoBlocks;
    }
    @Override
    public void agregarADestino(Bloque bloque) {
        algoblocks.agregarBloque(bloque);
    }

}
