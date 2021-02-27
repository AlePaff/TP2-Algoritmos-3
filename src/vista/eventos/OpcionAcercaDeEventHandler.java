package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;

public class OpcionAcercaDeEventHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Acerca De..");
        alert.setHeaderText("Alerta");
        alert.setContentText("Juego AlgoBlocks");
        alert.show();
    }
}
