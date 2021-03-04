package vista;

import Modelo.tablero.Posicion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import Modelo.personaje.Personaje;
import Modelo.tablero.*;
import vista.eventos.HandlerApplication;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Aplicacion extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("AlgoBlocks");

        AlgoBlocks algoBlocks = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,algoBlocks);
        Scene escenaJuego = new Scene(contenedorPrincipal,700,500);

        HandlerApplication handlerApplication = new HandlerApplication(stage,contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(handlerApplication);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,700,500);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }

    private AlgoBlocks crearModelo() {
        AlgoBlocks algoBlocks = new AlgoBlocks();
        return algoBlocks;
        //Tablero tablero = new Tablero(400, 400);
        //Personaje personaje = new Personaje(new Posicion(8,8,tablero));
        //return personaje;
    }
}
