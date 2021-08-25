package ru.mail.skorobogatov.www.interf;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

public class MainClass extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        String fxmlFile = "src/main/resources/fxml/Window.fxml";
        FXMLLoader loader = new FXMLLoader();
        InputStream fxmlStream = new FileInputStream(fxmlFile);
        Parent root = (Parent) loader.load(fxmlStream);

        stage.setTitle("Генератор билетов");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}