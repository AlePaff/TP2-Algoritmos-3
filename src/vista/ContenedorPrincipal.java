package vista;

import Modelo.tablero.Tablero;
import Modelo.personaje.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
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
    Tablero tablero;

    public ContenedorPrincipal(Stage stage,Personaje personaje){
        this.setMenu(stage);
        this.setCentro(personaje);
        this.setBotonera(personaje);
    }

    private void setBotonera(Personaje personaje){
        Button botonMoverDerecha = new Button();
        botonMoverDerecha.setText("Mover Derecha");
        //BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(vistaPersonaje,personaje,tablero);
        // botonMoverDerecha.setOnAction(moverDerechaHandler);

        Button botonMoverIzquierda = new Button();
        botonMoverIzquierda.setText("Mover Izquierda");
        //BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaPersonaje,personaje,tablero);
        //botonMoverIzquierda.setOnAction(moverIzquierdaHandler);

        Button botonMoverAbajo = new Button();
        botonMoverAbajo.setText("Mover Abajo");
        //BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(vistaPersonaje,personaje,tablero);
        //botonMoverAbajo.setOnAction(moverAbajoHandler);

        Button botonMoverArriba = new Button();
        botonMoverArriba.setText("Mover Arriba");
        //BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(vistaPersonaje,personaje,tablero);
        //botonMoverArriba.setOnAction(moverArribaHandler);

        Button botonLevantarLapiz = new Button();
        botonLevantarLapiz.setText("Levantar Lapiz");
        //BotonLevantarLapizHandler levantarLapizHandler = new BotonLevantarLapizHandler(vistaPersonaje,personaje);
        //botonLevantarLapiz.setOnAction(levantarLapizHandler);

        Button botonBajarLapiz = new Button();
        botonBajarLapiz.setText("Bajar Lapiz");
        //BotonBajarLapizHandler bajarLapizHandler = new BotonBajarLapizHandler(vistaPersonaje,personaje);
        //botonBajarLapiz.setOnAction(bajarLapizHandler);

       /* Button botonInvertirDireccion = new Button();
        botonInvertirDireccion.setText("Invertir Direccion");
        BotonInvertirDireccionHandler invertirDireccionHandler = new BotonInvertirDireccionHandler(vistaPersonaje,personaje,tablero);
        botonInvertirDireccion.setOnAction(invertirDireccionHandler);

        Button botonRepetirMovimiento = new Button();
        botonRepetirMovimiento.setText("Repetir Movimiento");
        BotonRepetirMovimientoHandler repetirMovimientoHandler = new BotonRepetirMovimientoHandler(vistaPersonaje,personaje,tablero);
        botonRepetirMovimiento.setOnAction(repetirMovimientoHandler);
        */

        VBox contenedorHorizontal = new VBox(botonMoverAbajo,botonBajarLapiz,botonLevantarLapiz,botonMoverArriba,botonMoverDerecha,botonMoverIzquierda);
        contenedorHorizontal.setSpacing(15);
        contenedorHorizontal.setPadding(new Insets(20));
        contenedorHorizontal.setStyle("-fx-background-color: red;");
        this.setBottom(contenedorHorizontal);

      /*  VBox contenedorVertical = new VBox(botonInvertirDireccion,botonRepetirMovimiento);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: orange;");
        this.setLeft(contenedorVertical);
        */
    }

    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
    }

    private void setCentro(Personaje personaje) {
        canvasCentral = new Canvas(400, 300);
        vistaPersonaje = new VistaPersonaje(personaje, canvasCentral);
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
