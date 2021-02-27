package vista;

import Modelo.tablero.Posicion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Modelo.personaje.Personaje;
import Modelo.tablero.*;
import vista.eventos.HandlerApplication;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("AlgoBlocks");
        Personaje personaje = crearModelo();
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
        Scene scene = new Scene(contenedorPrincipal,700,500);
        HandlerApplication handlerApplication = new HandlerApplication(stage,contenedorPrincipal.getBarraDeMenu());
        scene.setOnKeyPressed(handlerApplication);
        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,scene);
        Scene welcomeScene = new Scene(contenedorBienvenidos,700,500);
        stage.setScene(welcomeScene);
        stage.setFullScreen(false);
        stage.show();
    }

    private Personaje crearModelo(){
        Tablero tablero = new Tablero(500,300);
        Personaje personaje = new Personaje(new Posicion(8,8,tablero));
        return personaje;
    }
}
