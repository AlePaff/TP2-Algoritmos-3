package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vista.BarraDeMenu;

public class HandlerApplication implements EventHandler<KeyEvent> {
    private final Stage stage;
    private final BarraDeMenu barraDeMenu;

    public HandlerApplication(Stage stage,BarraDeMenu barraDeMenu){
        this.barraDeMenu = barraDeMenu;
        this.stage = stage;
    }
    @Override
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.ESCAPE){
            stage.setMaximized(true);
        }
        barraDeMenu.aplicacionMaximizada();
    }


}
