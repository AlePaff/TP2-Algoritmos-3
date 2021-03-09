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
    BarraDeMenu barraDeMenu;
    Canvas canvasCentral;
    VBox contenedorCentral;
    VistaAlgoritmo vistaAlgoritmo;

    public int ANCHO_CANVAS = 600;
    public int ALTO_CANVAS = 600;
    private VistaTablero vistaTablero;

    public ContenedorPrincipal(Stage stage,AlgoBlocks algoBlocks){
        this.setMenu(stage);
        this.setCentro(algoBlocks);
        this.setBotoneraAlgoritmo(algoBlocks);
        this.setBotoneraBloques(algoBlocks);
    }

    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setBotoneraBloques(AlgoBlocks algoBlocks){
        VBox contenedorBotoneraBloques = new VBox();
        new BotoneraBloques(algoBlocks, vistaAlgoritmo, contenedorBotoneraBloques);
        this.setLeft(contenedorBotoneraBloques);

    }

    private void setCentro(AlgoBlocks algoBlocks) {
        canvasCentral = new Canvas(ANCHO_CANVAS, ALTO_CANVAS);
        vistaTablero = new VistaTablero(algoBlocks, canvasCentral,ANCHO_CANVAS/algoBlocks.getBase(), ALTO_CANVAS/algoBlocks.getAltura());
        vistaTablero.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(30);
        contenedorCentral.setPadding(new Insets(35));

        Image image = new Image("file:src/main/java/vista/imagenes/imagen-de-fondo.jpg"/*,1200,800,false,false*/);
        BackgroundImage imagenDeFondo = new BackgroundImage(image, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);

        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }


    private void setBotoneraAlgoritmo(AlgoBlocks algoBlocks) {
        VBox contenedorBotonera = new VBox();
        VBox contenedorAlgoritmo = new VBox();
        vistaAlgoritmo = new VistaAlgoritmo(algoBlocks,contenedorAlgoritmo);
        new BotoneraAlgoritmo(algoBlocks, vistaAlgoritmo, vistaTablero, contenedorBotonera, contenedorAlgoritmo);
        this.setRight(contenedorBotonera);
    }


    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
