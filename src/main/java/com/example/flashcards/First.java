package com.example.flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class First extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(First.class.getResource("first.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 550);
        stage.setTitle("FlashCards");
        stage.setResizable(false);
        stage.setOnCloseRequest(e ->{
            e.consume();
            closeProgram(stage);
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void closeProgram(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation DialogBox");
        alert.setHeaderText("После закрытия вы закончите начатые сессии и не сможете начать новую!");
        alert.setContentText("Вы действительно хотите выйти?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null) == ButtonType.OK) stage.close();
    }
}