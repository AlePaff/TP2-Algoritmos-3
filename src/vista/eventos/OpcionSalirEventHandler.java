package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class OpcionSalirEventHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(ActionEvent actionEvent){
        System.exit(0);
    }
}
