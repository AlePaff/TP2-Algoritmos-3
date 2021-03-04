package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;


public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Acerca De..");
        alert.setHeaderText("Alerta");
        alert.setContentText("Juego AlgoBlocks");
        alert.show();
    }
}
