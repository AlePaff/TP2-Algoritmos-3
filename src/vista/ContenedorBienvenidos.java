package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import vista.eventos.BotonEntrarHandler;

public class ContenedorBienvenidos extends VBox {
    Stage stage;

    public ContenedorBienvenidos(Stage stage,Scene proximaEscena){
        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(30);
        this.setPadding(new Insets(35));

        Image image = new Image("file:src/vista/fondo-tenue.jpg",200,250,false,false);
        BackgroundImage imagenDeBienvenida = new BackgroundImage(image, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeBienvenida));


        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiquetaDeBienvenida = new Label();
        etiquetaDeBienvenida.setFont(Font.font("Comic Sans MS", FontWeight.BLACK, 30));

        etiquetaDeBienvenida.setText("Bienvenidos al juego AlgoBlocks!!");

        BotonEntrarHandler botonEntrarHandler = new BotonEntrarHandler(stage,proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);
        this.getChildren().addAll(etiquetaDeBienvenida,botonEntrar);
    }
}
