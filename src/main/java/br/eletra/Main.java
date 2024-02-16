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

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Caminho relativo para o arquivo de ícone dentro da pasta do projeto
        String iconePath = "ícone.png";

        // Verifique se o arquivo de ícone existe antes de tentar carregá-lo
        File iconeFile = new File(iconePath);
        if (iconeFile.exists()) {
            // Carregue a imagem do ícone
            Image icon = new Image(iconeFile.toURI().toString());

            // Defina o ícone da janela principal
            primaryStage.getIcons().add(icon);
        } else {
            // Se o arquivo de ícone não for encontrado, imprima uma mensagem de aviso
            System.out.println("Erro: Ícone não encontrado.");
        }

        // Criando o objeto FXML
        FXMLLoader loader = new FXMLLoader();

        // Carregar o arquivo FXML
        loader.setLocation(getClass().getResource("/Projeto_Integração.fxml"));
        Parent root = loader.load();

        // Configurar a cena
        Scene scene = new Scene(root);

        // Definir a cena na janela principal
        primaryStage.setScene(scene);
        primaryStage.setTitle("Projeto de Integração");
        primaryStage.setTitle(primaryStage.getTitle()); // Isso força a atribuição da classe CSS ao título
        primaryStage.getScene().getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());
        primaryStage.show();

        // Carregue o arquivo CSS diretamente no Stage
        String cssPath = Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm();
        if (cssPath != null) {
            primaryStage.getScene().getStylesheets().add(cssPath);
        } else {
            System.out.println("Erro: Arquivo CSS não encontrado.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}