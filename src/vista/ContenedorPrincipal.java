package vista;

import Modelo.tablero.AlgoBlocks;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    public ContenedorPrincipal(Stage stage, AlgoBlocks algoBlocks){
        this.setMenu(stage);
        this.setCentro(algoBlocks);
        this.setBotonera(algoBlocks);
    }

    private void setBotonera(AlgoBlocks algoBlocks){
        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Mover Derecha");
        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(algoBlocks, vistaPersonaje);
        botonMoverDerecha.setOnAction(moverDerechaHandler);

        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Mover Izquierda");
        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(algoBlocks, vistaPersonaje);
        botonMoverIzquierda.setOnAction(moverIzquierdaHandler);

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Mover Abajo");
        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(algoBlocks, vistaPersonaje);
        botonMoverAbajo.setOnAction(moverAbajoHandler);

        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Mover Arriba");
        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(algoBlocks, vistaPersonaje);
        botonMoverArriba.setOnAction(moverArribaHandler);

        Button botonLevantarLapiz = new Button();
        botonLevantarLapiz.setText("Levantar Lapiz");
        BotonSubirLapizHandler subirLapizHandler = new BotonSubirLapizHandler(algoBlocks, vistaPersonaje);
        botonLevantarLapiz.setOnAction(subirLapizHandler);

        Button botonBajarLapiz = new Button();
        botonBajarLapiz.setText("Bajar Lapiz");
        BotonBajarLapizHandler bajarLapizHandler = new BotonBajarLapizHandler(algoBlocks, vistaPersonaje);
        botonBajarLapiz.setOnAction(bajarLapizHandler);

        Button botonInvertirComportamiento = new Button();
        botonInvertirComportamiento.setText("Invertir Comportamiento");
        BotonInvertirComportamientoHandler invertirComportamientoHandler = new BotonInvertirComportamientoHandler(algoBlocks, vistaPersonaje);
        botonInvertirComportamiento.setOnAction(invertirComportamientoHandler);


        Label label = new Label();
        label.setText("RepetirMovimiento");
        TextField campoRepetirMovimiento = new TextField("Cantidad de repeticiones"); //REVISAR EXEPCIONES DE ESTO
        CampoRepetirMovimientoHandler repetirMovimientoHandler = new CampoRepetirMovimientoHandler(algoBlocks, vistaPersonaje, campoRepetirMovimiento);
        campoRepetirMovimiento.setOnAction(repetirMovimientoHandler);
        HBox bloqueRepetirMovimiento = new HBox(label, campoRepetirMovimiento);
        bloqueRepetirMovimiento.setSpacing(10);
        bloqueRepetirMovimiento.setPadding(new Insets(15));
        bloqueRepetirMovimiento.setStyle("-fx-background-color: orange;");


        Button botonEjecutar = new Button();
        botonEjecutar.setText("Ejecutar");
        BotonEjecutarHandler ejecutarHandler= new BotonEjecutarHandler(algoBlocks, vistaPersonaje);
        botonEjecutar.setOnAction(ejecutarHandler);


        VBox contenedorVertical = new VBox( botonMoverAbajo,botonBajarLapiz,botonLevantarLapiz,botonMoverArriba,botonMoverDerecha,botonMoverIzquierda, botonInvertirComportamiento,bloqueRepetirMovimiento);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: orange;");
        this.setLeft(contenedorVertical);

    }

    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setCentro(AlgoBlocks algoBlocks) {
        canvasCentral = new Canvas(400, 300);
        vistaPersonaje = new VistaPersonaje(algoBlocks, canvasCentral);
        vistaPersonaje.dibujar();

        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(30);
        contenedorCentral.setPadding(new Insets(35));

        Image image = new Image("file:src/vista/tablero-color-fondo.jpg",200,200,false,false);
        BackgroundImage imagenDeFondo = new BackgroundImage(image, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);

        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }

    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
