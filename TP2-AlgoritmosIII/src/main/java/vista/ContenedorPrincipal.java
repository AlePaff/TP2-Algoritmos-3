package vista;

import Modelo.personaje.Personaje;
import Modelo.tablero.AlgoBlocks;
import Modelo.tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;
import vista.eventos.*;

import java.awt.*;


public class ContenedorPrincipal extends BorderPane{
    BarraDeMenu barraDeMenu;
    VistaPersonaje vistaPersonaje;
    Canvas canvasCentral;
    VBox contenedorCentral;
    Tablero tablero;

    public ContenedorPrincipal(Stage stage,AlgoBlocks algoBlocks){
        this.setMenu(stage);
        this.setCentro(algoBlocks);
        this.setBotonera(algoBlocks);
    }


    private void setMenu(Stage stage){
        this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
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

        VBox contenedorVertical = new VBox(botonMoverDerecha,botonMoverIzquierda);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: orange;");
        this.setLeft(contenedorVertical);

    }

    private void setCentro(AlgoBlocks algoBlocks) {
        canvasCentral = new Canvas(700, 500);
        //canvasCentral.getGraphicsContext2D().setFill(Color.GREEN);
        vistaPersonaje = new VistaPersonaje(algoBlocks, canvasCentral);
        vistaPersonaje.dibujar();
        contenedorCentral = new VBox(canvasCentral);

        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(30);
        contenedorCentral.setPadding(new Insets(35));

        Image image = new Image("file:src/main/java/vista/imagenes/imagen-de-fondo.jpg",1200,800,false,false);
        BackgroundImage imagenDeFondo = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        this.setCenter(contenedorCentral);
    }

    public BarraDeMenu getBarraDeMenu(){
        return barraDeMenu;
    }

}
