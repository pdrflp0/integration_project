package br.eletra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.util.Objects;

public class Main extends Application {

    private static final int WIDTH = 900;
    private static final int HEIGHT = 625;

    @Override
    public void start(Stage primaryStage) throws Exception {

        String iconePath = "icon.png"; // Caminho para o arquivo do ícone

        File iconFile = new File(iconePath);
        if (iconFile.exists()) { // Verifique se o arquivo de ícone existe antes de tentar carregá-lo
            Image icon = new Image(iconFile.toURI().toString());  // Carregue a imagem do ícone

            primaryStage.getIcons().add(icon); // Defina o ícone da janela principal
        } else {
            System.out.println("Error: Icon not found.");
        }

        FXMLLoader loader = new FXMLLoader(); // Criando o objeto FXML

        // Carregar o arquivo FXML
        loader.setLocation(getClass().getResource("/integration_project.fxml"));
        Parent root = loader.load();

        // Configurar a cena
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Projeto de integração");
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setMaxHeight(HEIGHT);

        // Carregar o arquivo CSS diretamente no Stage
        String cssPath = Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm();
        if (cssPath != null) {
            primaryStage.getScene().getStylesheets().add(cssPath);
        } else {
            System.out.println("Error: CSS file not found.");
        }

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}