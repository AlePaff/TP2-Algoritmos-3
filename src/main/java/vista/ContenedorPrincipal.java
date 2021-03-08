package vista;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoBlocks;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;
import vista.eventos.*;


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
        this.setAlgoritmo(algoBlocks);
        this.setBotonera(algoBlocks);
    }

    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setBotonera(AlgoBlocks algoBlocks){
        VBox contenedorBotonera = new VBox();
        Botonera botonera = new Botonera(algoBlocks, vistaAlgoritmo, contenedorBotonera);
        this.setLeft(contenedorBotonera);

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


    private void setAlgoritmo(AlgoBlocks algoBlocks) {
        Label etiquetaAEjecutar = new Label("A EJECUTAR");
        etiquetaAEjecutar.setFont(Font.font("Italic", FontWeight.BLACK, 20));

        VBox contenedorAlgoritmo = new VBox();
        contenedorAlgoritmo.setPrefSize(160, 460);
        contenedorAlgoritmo.setStyle("-fx-background-color: grey;");
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setAlignment(Pos.TOP_CENTER);
        contenedorAlgoritmo.setPadding(new Insets(15));

        vistaAlgoritmo = new VistaAlgoritmo(algoBlocks,contenedorAlgoritmo);
        vistaAlgoritmo.mostrarBloques();

        Button botonEjecutar = new Button("Ejecutar");
        BotonEjecutarHandler ejecutarHandler= new BotonEjecutarHandler(algoBlocks, vistaAlgoritmo, vistaTablero);
        botonEjecutar.setOnAction(ejecutarHandler);

        Button botonBorrarAlgoritmo = new Button("Borrar");
        ImageView imagenBorrar = new ImageView();
        imagenBorrar.setImage(new Image("file:src/main/java/vista/imagenes/eliminar.png",20,20,false,false));
        botonBorrarAlgoritmo.setGraphic(imagenBorrar);
        BotonBorrarAlgoritmoHandler borrarAlgoritmoHandler = new BotonBorrarAlgoritmoHandler(algoBlocks, vistaAlgoritmo);
        botonBorrarAlgoritmo.setOnAction(borrarAlgoritmoHandler);

        TextField campoNombreAlgoritmo = new TextField("Ingresar nombre del Algoritmo");
        campoNombreAlgoritmo.setPrefWidth(180);
        Button botonGuardarAlgoritmo = new Button("Guardar");
        ImageView imagenGuardar = new ImageView();
        imagenGuardar.setImage(new Image("file:src/main/java/vista/imagenes/guardar.png",20,20,false,false));
        botonGuardarAlgoritmo.setGraphic(imagenGuardar);

        HBox hBoxGuardarAlgoritmo = new HBox(campoNombreAlgoritmo, botonGuardarAlgoritmo);
        hBoxGuardarAlgoritmo.setSpacing(10);
        hBoxGuardarAlgoritmo.setPadding(new Insets(15));
        VBox contenedorGuardarAlgoritmo = new VBox(hBoxGuardarAlgoritmo);
        hBoxGuardarAlgoritmo.setSpacing(10);
        hBoxGuardarAlgoritmo.setPadding(new Insets(15));

        BotonGuardarAlgoritmoHandler guardarAlgoritmoHandler = new BotonGuardarAlgoritmoHandler(algoBlocks, vistaAlgoritmo, campoNombreAlgoritmo, contenedorGuardarAlgoritmo);
        botonGuardarAlgoritmo.setOnAction(guardarAlgoritmoHandler);



        VBox contenedorBotonesAlgoritmo = new VBox(botonEjecutar, botonBorrarAlgoritmo, contenedorGuardarAlgoritmo);
        contenedorBotonesAlgoritmo.setSpacing(10);
        contenedorBotonesAlgoritmo.setPadding(new Insets(15));
        contenedorBotonesAlgoritmo.setAlignment(Pos.CENTER);


        VBox contenedorAEjecutar = new VBox(etiquetaAEjecutar, contenedorAlgoritmo, contenedorBotonesAlgoritmo);
        contenedorAEjecutar.setSpacing(10);
        contenedorAEjecutar.setPadding(new Insets(15));
        contenedorAEjecutar.setAlignment(Pos.TOP_CENTER);
        contenedorAEjecutar.setStyle("-fx-background-color: white;");
        this.setRight(contenedorAEjecutar);
    }


    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
