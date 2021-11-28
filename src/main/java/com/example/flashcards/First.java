package com.example.flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * processes and creates the first window
 */
public class First extends Application {

    /**
     * starts the processing of first window
     * @param stage is window that is sent for processing
     * @throws IOException is an exception in case the first window cannot be created
     */
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

    /**
     * the beginning of the beginning
     * @param args is something sacred
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * creates processes modular confirmation window events
     * @param stage is the prepared window that is sent for processing
     */
    public void closeProgram(Stage stage){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation DialogBox");
        alert.setHeaderText("После закрытия вы закончите начатые сессии и не сможете начать новую!");
        alert.setContentText("Вы действительно хотите выйти?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(null) == ButtonType.OK) stage.close();
    }
}