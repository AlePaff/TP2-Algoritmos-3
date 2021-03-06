package vista;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoBlocks;
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
    VistaPersonaje vistaPersonaje;
    Canvas canvasCentral;
    VBox contenedorCentral;
    VistaAlgoritmo vistaAlgoritmo;

    public ContenedorPrincipal(Stage stage,AlgoBlocks algoBlocks){
        this.setMenu(stage);
        this.setCentro(algoBlocks);
        this.setBotonera(algoBlocks);
        this.setAlgoritmo(algoBlocks);
    }

    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setBotonera(AlgoBlocks algoBlocks){
        Label etiquetaBloques = new Label("BLOQUES");
        etiquetaBloques.setFont(Font.font("Italic", FontWeight.BLACK, 20));

        Button botonSubirLapiz = new Button("Subir Lapiz");
        BotonSubirLapizHandler subirLapizHandler = new BotonSubirLapizHandler(algoBlocks, vistaAlgoritmo);
        botonSubirLapiz.setOnAction(subirLapizHandler);

        Button botonBajarLapiz = new Button("Bajar Lapiz");
        BotonBajarLapizHandler bajarLapizHandler = new BotonBajarLapizHandler(algoBlocks, vistaAlgoritmo);
        botonBajarLapiz.setOnAction(bajarLapizHandler);

        HBox contenedorPosicionLapiz = new HBox(botonSubirLapiz, botonBajarLapiz);
        contenedorPosicionLapiz.setSpacing(10);
        contenedorPosicionLapiz.setPadding(new Insets(15));

        Label etiquetaMovimiento = new Label("Movimiento:");

        Button botonMoverDerecha = new Button("Derecha");
        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverDerecha.setOnAction(moverDerechaHandler);

        Button botonMoverIzquierda = new Button("Izquierda");
        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverIzquierda.setOnAction(moverIzquierdaHandler);

        HBox contenedorIzquierdaYDerecha = new HBox(botonMoverIzquierda, botonMoverDerecha);
        contenedorPosicionLapiz.setSpacing(100);
        contenedorPosicionLapiz.setPadding(new Insets(15));
        contenedorIzquierdaYDerecha.setAlignment(Pos.CENTER);

        Button botonMoverAbajo = new Button("Abajo");
        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(algoBlocks, vistaAlgoritmo);
        botonMoverAbajo.setOnAction(moverAbajoHandler);

        Button botonMoverArriba = new Button("Arriba");
        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(algoBlocks, vistaAlgoritmo);
        botonMoverArriba.setOnAction(moverArribaHandler);

        VBox contenedorMovimientos = new VBox(botonMoverArriba, contenedorIzquierdaYDerecha, botonMoverAbajo);
        contenedorPosicionLapiz.setSpacing(10);
        contenedorPosicionLapiz.setPadding(new Insets(15));
        contenedorPosicionLapiz.setAlignment(Pos.CENTER);

        Label etiquetaRepeticiones = new Label("Repetir Movimiento:");

        Button botonRepetirMovimientoDosVeces = new Button("Dos Veces");
        BotonRepetirMovimientoHandler repetirMovimientoDosVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 2, vistaAlgoritmo);
        botonRepetirMovimientoDosVeces.setOnAction(repetirMovimientoDosVecesHandler);

        Button botonRepetirMovimientoTresVeces = new Button("Tres Veces");
        BotonRepetirMovimientoHandler repetirMovimientoTresVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 3, vistaAlgoritmo);
        botonRepetirMovimientoDosVeces.setOnAction(repetirMovimientoTresVecesHandler);

        HBox contenedorRepeticiones = new HBox(botonRepetirMovimientoDosVeces, botonRepetirMovimientoTresVeces);
        contenedorPosicionLapiz.setSpacing(20);
        contenedorPosicionLapiz.setPadding(new Insets(15));

        //FALTA BOTON INVERTIR COMPORTAMIENTO

        VBox contenedorBotonera = new VBox(etiquetaBloques,contenedorPosicionLapiz, etiquetaMovimiento, contenedorMovimientos, etiquetaRepeticiones, contenedorRepeticiones);
        contenedorBotonera.setSpacing(10);
        contenedorBotonera.setPadding(new Insets(15));
        contenedorBotonera.setStyle("-fx-background-color: white;");
        this.setLeft(contenedorBotonera);

    }

    private void setCentro(AlgoBlocks algoBlocks) {
        canvasCentral = new Canvas(500, 500);
        vistaPersonaje = new VistaPersonaje(algoBlocks, canvasCentral);
        vistaPersonaje.dibujar();
        contenedorCentral = new VBox(canvasCentral);

        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(30);
        contenedorCentral.setPadding(new Insets(35));

        Image image = new Image("file:src/main/java/vista/imagenes/fondo.jpg"/*,1200,800,false,false*/);
        BackgroundImage imagenDeFondo = new BackgroundImage(image, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }


    private void setAlgoritmo(AlgoBlocks algoBlocks) {
        Label etiquetaAEjecutar = new Label("A EJECUTAR");
        etiquetaAEjecutar.setFont(Font.font("Italic", FontWeight.BLACK, 20));

        Canvas contenedorAlgoritmo = new Canvas(150, 500);
        vistaAlgoritmo = new VistaAlgoritmo(algoBlocks,contenedorAlgoritmo);
        vistaAlgoritmo.mostrarBloques();

        Button botonEjecutar = new Button("Ejecutar");
        BotonEjecutarHandler ejecutarHandler= new BotonEjecutarHandler(vistaPersonaje, algoBlocks, vistaAlgoritmo);
        botonEjecutar.setOnAction(ejecutarHandler);

        Button botonGuardarAlgoritmo = new Button("Guardar Algoritmo");
        BotonGuardarAlgoritmoHandler guardarAlgoritmoHandler = new BotonGuardarAlgoritmoHandler(algoBlocks, vistaAlgoritmo);
        botonGuardarAlgoritmo.setOnAction(guardarAlgoritmoHandler);

        Button botonBorrarAlgoritmo = new Button("Borrar");
        BotonBorrarAlgoritmoHandler borrarAlgoritmoHandler = new BotonBorrarAlgoritmoHandler(algoBlocks, vistaAlgoritmo);
        botonBorrarAlgoritmo.setOnAction(borrarAlgoritmoHandler);

        VBox contenedorBotones = new VBox(botonEjecutar, botonGuardarAlgoritmo, botonBorrarAlgoritmo);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15));
        //ver cómo hacer para que este contenedor quede abajo


        VBox contenedorAEjecutar = new VBox(etiquetaAEjecutar, contenedorAlgoritmo, contenedorBotones);
        contenedorAEjecutar.setSpacing(10);
        contenedorAEjecutar.setPadding(new Insets(15));
        contenedorAEjecutar.setStyle("-fx-background-color: white;");
        this.setRight(contenedorAEjecutar);
    }


    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
