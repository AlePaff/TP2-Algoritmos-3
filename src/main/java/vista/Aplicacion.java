package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import modelo.AlgoBlocks;
import vista.eventos.HandlerApplication;

public class Aplicacion extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("AlgoBlocks");

        AlgoBlocks algoBlocks = crearModelo();

        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,algoBlocks);
        ScrollPane scrollPrincipal = new ScrollPane();
        scrollPrincipal.setContent(contenedorPrincipal);
        scrollPrincipal.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPrincipal.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Scene escenaJuego = new Scene(scrollPrincipal,700,500);

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
    }
}
