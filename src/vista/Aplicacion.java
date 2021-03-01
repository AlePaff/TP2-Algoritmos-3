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

        AlgoBlocks algoBlocks = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, algoBlocks);
        Scene escenaJuego = new Scene(contenedorPrincipal,700,500);

        HandlerApplication handlerApplication = new HandlerApplication(stage,contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(handlerApplication);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage,escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos,700,500);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }

    private AlgoBlocks crearModelo(){
        AlgoBlocks algoBlocks = new AlgoBlocks();
        return algoBlocks;
    }
}
