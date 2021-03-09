package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.AlgoBlocks;
import vista.eventos.BotonBorrarAlgoritmoHandler;
import vista.eventos.BotonEjecutarHandler;
import vista.eventos.BotonGuardarAlgoritmoHandler;
import vista.eventos.BotonReiniciarJuegoHandler;

public class BotoneraAlgoritmo extends VBox{

    private static final String FONDO_CONTENEDOR_ALGORITMO = "-fx-background-color: grey;";
    private static final String FONDO_CONTENEDOR_A_EJECUTAR = "-fx-background-color: white;";
    private static final String TIPOGRAFIA = "Italic";
    private static final double TAMANIO_ETIQUETA = 20;
    public static final Image IMAGEN_EJECUTAR =  new Image("file:src/main/java/vista/imagenes/ejecutar.png",20,20,false,false);
    public static final Image IMAGEN_BORRAR = new Image("file:src/main/java/vista/imagenes/eliminar.png",20,20,false,false);
    public static final Image IMAGEN_REINICIAR = new Image("file:src/main/java/vista/imagenes/juego.png",20,20,false,false);
    public static final Image IMAGEN_GUARDAR = new Image("file:src/main/java/vista/imagenes/guardar.png",20,20,false,false);



    public BotoneraAlgoritmo(AlgoBlocks algoBlocks, VistaAlgoritmo vistaAlgoritmo, VistaTablero vistaTablero, VBox contenedorAlgoritmo) {

        Label etiquetaBotonera = new Label("A EJECUTAR");
        etiquetaBotonera.setFont(Font.font(TIPOGRAFIA, FontWeight.BLACK, TAMANIO_ETIQUETA));

        //set contenedor del Algoritmo
        contenedorAlgoritmo.setPrefSize(340, 460);
        contenedorAlgoritmo.setStyle(FONDO_CONTENEDOR_ALGORITMO);
        contenedorAlgoritmo.setSpacing(10);
        contenedorAlgoritmo.setAlignment(Pos.TOP_CENTER);
        contenedorAlgoritmo.setPadding(new Insets(15));

        ScrollPane scrollContenedorAlgoritmo = new ScrollPane(contenedorAlgoritmo);
        scrollContenedorAlgoritmo.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollContenedorAlgoritmo.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollContenedorAlgoritmo.setPannable(true);

        vistaAlgoritmo.mostrarBloques();

        //set botones
        BotonEjecutarHandler ejecutarHandler= new BotonEjecutarHandler(algoBlocks, vistaAlgoritmo, vistaTablero);
        Boton botonEjecutar = new Boton("Ejecutar",IMAGEN_EJECUTAR, ejecutarHandler);
        botonEjecutar.setOnAction(ejecutarHandler);

        BotonBorrarAlgoritmoHandler borrarAlgoritmoHandler = new BotonBorrarAlgoritmoHandler(algoBlocks, vistaAlgoritmo);
        Boton botonBorrarAlgoritmo = new Boton("Borrar", IMAGEN_BORRAR, borrarAlgoritmoHandler);

        BotonReiniciarJuegoHandler reiniciarJuegoHandler = new BotonReiniciarJuegoHandler(algoBlocks, vistaAlgoritmo, vistaTablero);
        Boton botonReiniciarJuego = new Boton("Reiniciar Juego", IMAGEN_REINICIAR,reiniciarJuegoHandler);

        HBox contenedorBotonesAuxiliar = new HBox(botonEjecutar, botonBorrarAlgoritmo, botonReiniciarJuego);
        contenedorBotonesAuxiliar.setSpacing(10);
        contenedorBotonesAuxiliar.setPadding(new Insets(15));
        contenedorBotonesAuxiliar.setAlignment(Pos.CENTER);

        // set vista Bloque Personalizado
        TextField campoNombreAlgoritmo = new TextField("Ingresar nombre del Algoritmo");
        campoNombreAlgoritmo.setPrefWidth(180);

        Button botonGuardarAlgoritmo = new Button("Guardar");
        botonGuardarAlgoritmo.setGraphic(new ImageView(IMAGEN_GUARDAR));

        HBox contenedorGuardarAlgoritmoAuxiliar = new HBox(campoNombreAlgoritmo, botonGuardarAlgoritmo);
        contenedorGuardarAlgoritmoAuxiliar.setSpacing(10);
        contenedorGuardarAlgoritmoAuxiliar.setPadding(new Insets(15));

        VBox contenedorGuardarAlgoritmo = new VBox(contenedorGuardarAlgoritmoAuxiliar);
        contenedorGuardarAlgoritmoAuxiliar.setSpacing(10);
        contenedorGuardarAlgoritmoAuxiliar.setPadding(new Insets(15));

        BotonGuardarAlgoritmoHandler guardarAlgoritmoHandler = new BotonGuardarAlgoritmoHandler(algoBlocks, vistaAlgoritmo, campoNombreAlgoritmo, contenedorGuardarAlgoritmo);
        botonGuardarAlgoritmo.setOnAction(guardarAlgoritmoHandler);

        VBox contenedorBotones = new VBox(contenedorBotonesAuxiliar, contenedorGuardarAlgoritmo);
        contenedorBotones.setSpacing(10);
        contenedorBotones.setPadding(new Insets(15));
        contenedorBotones.setAlignment(Pos.CENTER);

        ScrollPane scrollContenedorBotones = new ScrollPane(contenedorBotones);
        scrollContenedorBotones.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollContenedorBotones.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollContenedorBotones.setPannable(true);


        getChildren().addAll(etiquetaBotonera, contenedorAlgoritmo, contenedorBotones,scrollContenedorAlgoritmo,scrollContenedorBotones);
        setSpacing(10);
        setPadding(new Insets(5));
        setAlignment(Pos.TOP_CENTER);
        setStyle(FONDO_CONTENEDOR_A_EJECUTAR);
    }
}
