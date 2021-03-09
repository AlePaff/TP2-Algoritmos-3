package vista.eventos;

import javafx.event.ActionEvent;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.bloques.Conjunto;
import modelo.bloques.InvertirComportamiento;
import vista.VistaAlgoritmo;

public class BotonInvertirComportamientoHandler extends BotonBloqueHandler {
    private AlgoBlocks algoBlocks;
    private VistaAlgoritmo vistaAlgoritmo;

    public BotonInvertirComportamientoHandler(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){
        super(algoBlocks, vistaAlgoritmo);
        this.algoBlocks = algoBlocks;
        this.vistaAlgoritmo = vistaAlgoritmo;
    }

  //  public void mostrarBloques(){
    //    Conjunto bloque = (Conjunto) crearBloque();
      //  vistaAlgoritmo.mostrarImagen(bloque);
    //}

    @Override
    public void handle(ActionEvent actionEvent) {
        Conjunto bloque = (Conjunto) crearBloque();
        estrategia.agregarADestino(bloque);

        setEstrategia( new EstrategiaHandleConjunto(bloque));

        this.vistaAlgoritmo.update();
    }

    @Override
    public Bloque crearBloque(){
        return new InvertirComportamiento();
    }
}
