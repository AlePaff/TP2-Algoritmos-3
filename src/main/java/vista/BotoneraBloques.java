package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import modelo.AlgoBlocks;
import vista.eventos.*;

public class BotoneraBloques extends VBox{
    public final Image IMAGEN_SUBIR_LAPIZ = new Image("file:src/main/java/vista/imagenes/lapizArriba.png",20,20,false,false);
    public Image IMAGEN_TERMINAR = new Image("file:src/main/java/vista/imagenes/lapizArriba.png",20,20,false,false);
    public Image IMAGEN_BAJAR_LAPIZ = new Image("file:src/main/java/vista/imagenes/lapizAbajo.png",20,20,false,false);
    public Image IMAGEN_DERECHA = new Image("file:src/main/java/vista/imagenes/derecha.png",20,20,false,false);
    public Image IMAGEN_IZQUIERDA = new Image("file:src/main/java/vista/imagenes/izquierda.png",20,20,false,false);
    public Image IMAGEN_ABAJO = new Image("file:src/main/java/vista/imagenes/abajo.png",20,20,false,false);
    public Image IMAGEN_ARRIBA = new Image("file:src/main/java/vista/imagenes/arriba.png",20,20,false,false);
    public Image IMAGEN_REPETIR = new Image("file:src/main/java/vista/imagenes/repetir.png",20,20,false,false);
    public Image IMAGEN_INVERTIR = new Image("file:src/main/java/vista/imagenes/invertir.png",20,20,false,false);
    public String FONDO_CONTENEDOR = "-fx-background-color: white;";
    private final String TIPOGRAFIA = "Italic";
    private final double TAMAÑO_TITULO = 20;
    private final double TAMAÑO_COMENTARIO = 15;


    public BotoneraBloques(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo){

        Label etiquetaBloques = new Label("BOTONES");
        etiquetaBloques.setFont(Font.font(TIPOGRAFIA, FontWeight.BLACK, TAMAÑO_TITULO));

        Label etiquetaLapiz = new Label("El juego inicia con el Lapiz arriba," + "\n" + "para poder dibujar debe bajarlo");
        etiquetaLapiz.setFont(Font.font(TIPOGRAFIA,FontWeight.EXTRA_LIGHT, FontPosture.ITALIC,TAMAÑO_COMENTARIO));
        etiquetaLapiz.setLineSpacing(15);
        Label etiquetaPunteada = new Label("~ . ~ . ~ . ~ . ~ . ~ . ~ . ~ . ~ ");


        BotonSubirLapizHandler subirLapizHandler = new BotonSubirLapizHandler(algoBlocks, vistaAlgoritmo);
        Boton botonSubirLapiz = new Boton("Subir Lapiz",IMAGEN_SUBIR_LAPIZ,subirLapizHandler);

        BotonBajarLapizHandler bajarLapizHandler = new BotonBajarLapizHandler(algoBlocks, vistaAlgoritmo);
        Boton botonBajarLapiz = new Boton("Bajar Lapiz", IMAGEN_BAJAR_LAPIZ, bajarLapizHandler);

        HBox contenedorPosicionLapiz = new HBox(botonSubirLapiz, botonBajarLapiz);
        contenedorPosicionLapiz.setSpacing(10);
        contenedorPosicionLapiz.setPadding(new Insets(15));
        contenedorPosicionLapiz.setAlignment(Pos.CENTER);


        Label etiquetaMovimiento = new Label("Movimiento:");

        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(algoBlocks, vistaAlgoritmo);
        Boton botonMoverDerecha = new Boton("Derecha",IMAGEN_DERECHA, moverDerechaHandler);

        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoBlocks, vistaAlgoritmo);
        Boton botonMoverIzquierda = new Boton("Izquierda",IMAGEN_IZQUIERDA, moverIzquierdaHandler);

        HBox contenedorIzquierdaYDerecha = new HBox(botonMoverIzquierda, botonMoverDerecha);
        contenedorIzquierdaYDerecha.setSpacing(100);
        contenedorIzquierdaYDerecha.setPadding(new Insets(15));
        contenedorIzquierdaYDerecha.setAlignment(Pos.CENTER);

        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(algoBlocks, vistaAlgoritmo);
        Boton botonMoverAbajo = new Boton("Abajo", IMAGEN_ABAJO, moverAbajoHandler);

        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(algoBlocks, vistaAlgoritmo);
        Boton botonMoverArriba = new Boton("Arriba", IMAGEN_ARRIBA, moverArribaHandler);

        VBox contenedorMovimientos = new VBox(botonMoverArriba, contenedorIzquierdaYDerecha, botonMoverAbajo);
        contenedorMovimientos.setSpacing(10);
        contenedorMovimientos.setPadding(new Insets(15));
        contenedorMovimientos.setAlignment(Pos.CENTER);


        Label etiquetaRepeticiones = new Label("Repetir Movimiento:");

        BotonRepetirMovimientoHandler repetirMovimientoDosVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 2, vistaAlgoritmo);
        Boton botonRepetirMovimientoDosVeces = new Boton("Dos Veces", IMAGEN_REPETIR, repetirMovimientoDosVecesHandler);

        BotonRepetirMovimientoHandler repetirMovimientoTresVecesHandler = new BotonRepetirMovimientoHandler(algoBlocks, 3, vistaAlgoritmo);
        Boton botonRepetirMovimientoTresVeces = new Boton("Tres Veces", IMAGEN_REPETIR, repetirMovimientoTresVecesHandler);

        HBox contenedorRepeticiones = new HBox(botonRepetirMovimientoDosVeces, botonRepetirMovimientoTresVeces);
        contenedorRepeticiones.setSpacing(20);
        contenedorRepeticiones.setPadding(new Insets(15));
        contenedorRepeticiones.setAlignment(Pos.CENTER);

        BotonInvertirComportamientoHandler invertirComportamientoHandler = new BotonInvertirComportamientoHandler(algoBlocks, vistaAlgoritmo);
        Boton botonInvertirComportamiento = new Boton("Invertir Comportamiento", IMAGEN_INVERTIR, invertirComportamientoHandler);

        BotonTerminarAgregarBloquesAConjuntoHandler terminarAgregarBloquesAConjuntoHandler = new BotonTerminarAgregarBloquesAConjuntoHandler(algoBlocks, vistaAlgoritmo);
        Boton botonTerminarAgregarBloquesAConjunto = new Boton("Terminar", IMAGEN_TERMINAR, terminarAgregarBloquesAConjuntoHandler);

        getChildren().addAll(etiquetaBloques,contenedorPosicionLapiz, etiquetaMovimiento, contenedorMovimientos, etiquetaRepeticiones, contenedorRepeticiones,botonInvertirComportamiento,etiquetaPunteada,etiquetaLapiz, botonTerminarAgregarBloquesAConjunto);
        setSpacing(10);
        setPadding(new Insets(5));
        setAlignment(Pos.TOP_CENTER);
        setStyle(FONDO_CONTENEDOR);

    }

}
