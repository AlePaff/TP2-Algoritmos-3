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

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,personaje);
        Scene escenaJuego = new Scene(contenedorPrincipal,700,500);

        HandlerApplication handlerApplication = new HandlerApplication(stage,contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(handlerApplication);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,700,500);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }

    private Personaje crearModelo(){
        //Esto creo que deberiamos inicializarlo de otra manera dirigiendo a AlgoBlocks
        Tablero tablero = new Tablero(500,300);
        Personaje personaje = new Personaje(new Posicion(8,8,tablero));
        return personaje;
    }
}
