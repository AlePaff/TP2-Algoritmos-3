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
       // boton.setPrefSize(300,400);
       // ScrollPane scrollPrincipal = new ScrollPane();
       // scrollPrincipal.setContent(boton);
       // scrollPrincipal.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
       // scrollPrincipal.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
       // Scene escena = new Scene(scrollPrincipal,700,500);
        stage.setScene(escena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}
