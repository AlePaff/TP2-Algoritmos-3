package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.awt.*;

public class BotonEntrarHandler implements EventHandler<ActionEvent> {
    Stage stage;
    Scene escena;
    //Button boton = new Button();

    public BotonEntrarHandler(Stage stage, Scene escena){
        this.stage = stage;
        this.escena = escena;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        stage.setScene(escena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
