package vista;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Boton extends Button {


    public Boton(String nombre, Image imagen, EventHandler handler){
        setText(nombre);
        ImageView imagenBloque = new ImageView();
        imagenBloque.setImage(imagen);
        this.setGraphic(imagenBloque);
        this.setOnAction(handler);
    }

}
