package vista;

import modelo.AlgoBlocks;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;


public class ContenedorPrincipal extends BorderPane{
    private BarraDeMenu barraDeMenu;
    private VistaAlgoritmo vistaAlgoritmo;
    private VistaTablero vistaTablero;

    public int ANCHO_CANVAS = 600;
    public int ALTO_CANVAS = 600;


    public ContenedorPrincipal(Stage stage,AlgoBlocks algoBlocks){
        this.setMenu(stage);
        this.setCentro(algoBlocks);
        this.setBotoneraAlgoritmo(algoBlocks);
        this.setBotoneraBloques(algoBlocks);
    }

    private void setMenu(Stage stage){
        barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setBotoneraBloques(AlgoBlocks algoBlocks){
        BotoneraBloques botoneraBloques = new BotoneraBloques(algoBlocks, vistaAlgoritmo);
        this.setLeft(botoneraBloques);

    }

    private void setCentro(AlgoBlocks algoBlocks) {
        Canvas canvasCentral = new Canvas(ANCHO_CANVAS, ALTO_CANVAS);

        vistaTablero = new VistaTablero(algoBlocks, canvasCentral,ANCHO_CANVAS/algoBlocks.getBase(), ALTO_CANVAS/algoBlocks.getAltura());
        vistaTablero.dibujar();

        Centro contenedorCentral = new Centro(canvasCentral);
        this.setCenter(contenedorCentral);
    }


    private void setBotoneraAlgoritmo(AlgoBlocks algoBlocks) {
        VBox contenedorAlgoritmo = new VBox();

        vistaAlgoritmo = new VistaAlgoritmo(algoBlocks,contenedorAlgoritmo);

        BotoneraAlgoritmo contenedorBotonera = new BotoneraAlgoritmo(algoBlocks, vistaAlgoritmo, vistaTablero, contenedorAlgoritmo);
        this.setRight(contenedorBotonera);
    }


    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
