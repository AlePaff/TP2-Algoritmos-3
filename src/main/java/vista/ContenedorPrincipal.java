package vista;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoBlocks;
import modelo.bloques.Bloque;
import modelo.tablero.Tablero;
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
        Label etiquetaBloques = new Label("BLOQUES");
        etiquetaBloques.setFont(Font.font("Italic", FontWeight.BLACK, 20));

        Button botonSubirLapiz = new Button("Subir Lapiz");
        ImageView imagenSubirLapiz = new ImageView();
        imagenSubirLapiz.setImage(new Image("file:src/main/java/vista/imagenes/lapizArriba.png",20,20,false,false));
        botonSubirLapiz.setGraphic(imagenSubirLapiz);
        BotonSubirLapizHandler subirLapizHandler = new BotonSubirLapizHandler(algoBlocks, vistaAlgoritmo);
        botonSubirLapiz.setOnAction(subirLapizHandler);

        Button botonBajarLapiz = new Button("Bajar Lapiz");
        ImageView imagenBajarLapiz = new ImageView();
        imagenBajarLapiz.setImage(new Image("file:src/main/java/vista/imagenes/lapizAbajo.png",20,20,false,false));
        botonBajarLapiz.setGraphic(imagenBajarLapiz);
        BotonBajarLapizHandler bajarLapizHandler = new BotonBajarLapizHandler(algoBlocks, vistaAlgoritmo);
        botonBajarLapiz.setOnAction(bajarLapizHandler);

        HBox contenedorPosicionLapiz = new HBox(botonSubirLapiz, botonBajarLapiz);
        contenedorPosicionLapiz.setSpacing(10);
        contenedorPosicionLapiz.setPadding(new Insets(15));

        Label etiquetaMovimiento = new Label("Movimiento:");

        Button botonMoverDerecha = new Button("Derecha");
        ImageView imagenMoverDerecha = new ImageView();
        imagenMoverDerecha.setImage(new Image("file:src/main/java/vista/imagenes/derecha.png",20,20,false,false));
        botonMoverDerecha.setGraphic(imagenMoverDerecha);
        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverDerecha.setOnAction(moverDerechaHandler);

        Button botonMoverIzquierda = new Button("Izquierda");
        ImageView imagenMoverIzquierda = new ImageView();
        imagenMoverIzquierda.setImage(new Image("file:src/main/java/vista/imagenes/izquierda.png",20,20,false,false));
        botonMoverIzquierda.setGraphic(imagenMoverIzquierda);
        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverIzquierda.setOnAction(moverIzquierdaHandler);

        HBox contenedorIzquierdaYDerecha = new HBox(botonMoverIzquierda, botonMoverDerecha);
        contenedorIzquierdaYDerecha.setSpacing(100);
        contenedorIzquierdaYDerecha.setPadding(new Insets(15));
        contenedorIzquierdaYDerecha.setAlignment(Pos.CENTER);

        Button botonMoverAbajo = new Button("Abajo");
        ImageView imagenMoverAbajo = new ImageView();
        imagenMoverAbajo.setImage(new Image("file:src/main/java/vista/imagenes/abajo.png",20,20,false,false));
        botonMoverAbajo.setGraphic(imagenMoverAbajo);
        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(algoBlocks, vistaAlgoritmo);
        botonMoverAbajo.setOnAction(moverAbajoHandler);

        Button botonMoverArriba = new Button("Arriba");
        ImageView imagenMoverArriba = new ImageView();
        imagenMoverArriba.setImage(new Image("file:src/main/java/vista/imagenes/arriba.png",20,20,false,false));
        botonMoverArriba.setGraphic(imagenMoverArriba);
        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverArriba.setOnAction(moverArribaHandler);

        VBox contenedorMovimientos = new VBox(botonMoverArriba, contenedorIzquierdaYDerecha, botonMoverAbajo);
        contenedorMovimientos.setSpacing(10);
        contenedorMovimientos.setPadding(new Insets(15));
        contenedorMovimientos.setAlignment(Pos.CENTER);

        Label etiquetaRepeticiones = new Label("Repetir Movimiento:");

        Button botonRepetirMovimientoDosVeces = new Button("Dos Veces");
        ImageView imagenRepetirDosVeces = new ImageView();
        imagenRepetirDosVeces.setImage(new Image("file:src/main/java/vista/imagenes/repetir.png",20,20,false,false));
        botonRepetirMovimientoDosVeces.setGraphic(imagenRepetirDosVeces);
        BotonRepetirMovimientoHandler repetirMovimientoDosVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 2, vistaAlgoritmo);
        botonRepetirMovimientoDosVeces.setOnAction(repetirMovimientoDosVecesHandler);

        Button botonRepetirMovimientoTresVeces = new Button("Tres Veces");
        ImageView imagenRepetirTresVeces = new ImageView();
        imagenRepetirTresVeces.setImage(new Image("file:src/main/java/vista/imagenes/repetir.png",20,20,false,false));
        botonRepetirMovimientoTresVeces.setGraphic(imagenRepetirTresVeces);
        BotonRepetirMovimientoHandler repetirMovimientoTresVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 3, vistaAlgoritmo);
        botonRepetirMovimientoTresVeces.setOnAction(repetirMovimientoTresVecesHandler);

        HBox contenedorRepeticiones = new HBox(botonRepetirMovimientoDosVeces, botonRepetirMovimientoTresVeces);
        contenedorRepeticiones.setSpacing(20);
        contenedorRepeticiones.setPadding(new Insets(15));

        Button botonInvertirComportamiento = new Button("Invertir Comportamiento");
        ImageView imagenInvertir = new ImageView();
        imagenInvertir.setImage(new Image("file:src/main/java/vista/imagenes/invertir.png",20,20,false,false));
        botonInvertirComportamiento.setGraphic(imagenInvertir);
        BotonInvertirComportamientoHandler InvertirComportamientoHandler = new BotonInvertirComportamientoHandler(algoBlocks, vistaAlgoritmo);
        botonInvertirComportamiento.setOnAction(InvertirComportamientoHandler);

        HBox contenedorInvertir = new HBox(botonInvertirComportamiento);
        contenedorInvertir.setSpacing(20);
        contenedorInvertir.setPadding(new Insets(15));

        /*Button botonBloquePersonalizado = new Button("Bloque Personalizado");
        BotonBloquePersonalizadoHandler BloquePersonalizadoHandler = new BotonBloquePersonalizadoHandler(algoBlocks, vistaAlgoritmo);
        botonBloquePersonalizado.setOnAction(BloquePersonalizadoHandler);

        HBox contenedorBloquePersonalizado = new HBox(botonBloquePersonalizado);
        contenedorBloquePersonalizado.setSpacing(20);
        contenedorBloquePersonalizado.setPadding(new Insets(15));*/


        VBox contenedorBotonera = new VBox(etiquetaBloques,contenedorPosicionLapiz, etiquetaMovimiento, contenedorMovimientos, etiquetaRepeticiones, contenedorRepeticiones,contenedorInvertir);
        contenedorBotonera.setSpacing(10);
        contenedorBotonera.setPadding(new Insets(15));
        contenedorBotonera.setStyle("-fx-background-color: white;");
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
        contenedorAlgoritmo.setPrefSize(210, 460);
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
        campoNombreAlgoritmo.setPrefWidth(200);
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
        contenedorAEjecutar.setStyle("-fx-background-color: white;");
        this.setRight(contenedorAEjecutar);
    }


    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
