package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarHandler implements EventHandler<ActionEvent> {
    Stage stage;
    Scene escena;

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
