package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
public class Centro extends VBox{
    public Image FONDO = new Image("file:src/main/java/vista/imagenes/imagen-de-fondo.jpg"/*,1200,800,false,false*/);

    public Centro(Canvas canvasCentral) {
        BackgroundImage imagenDeFondo = new BackgroundImage(FONDO, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        getChildren().add(canvasCentral);
        setAlignment(Pos.CENTER);
        setSpacing(30);
        setPadding(new Insets(35));
        setBackground(new Background(imagenDeFondo));
    }

}
