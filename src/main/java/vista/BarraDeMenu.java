package vista;

import javafx.scene.control.*;
import javafx.stage.Stage;
import vista.eventos.OpcionAcercaDeEventHandler;
import vista.eventos.OpcionPantallaCompletaEventHandler;
import vista.eventos.OpcionSalirEventHandler;

public class BarraDeMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla Completa");

    public BarraDeMenu(Stage stage){
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda (?)");

        MenuItem opcionSalir = new MenuItem("Salir");
        OpcionSalirEventHandler opcionSalirEventHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirEventHandler);

        MenuItem opcionAbrir = new MenuItem("Abrir");

        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        OpcionAcercaDeEventHandler opcionAcercaDeEventHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeEventHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionAbrir,new SeparatorMenuItem(),opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionAcercaDe);

        this.getMenus().addAll(menuArchivo,menuAyuda,menuVer);
    }

    public void aplicacionMaximizada(){
        opcionPantallaCompleta.setDisable(false);
    }
}
