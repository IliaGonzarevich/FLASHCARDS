package com.example.flashcards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * processes and creates a second window
 */
public class Second extends Application {

    Stage stage = new Stage();

    /**
     * starts the processing of second window
     * @param secondStage is the prepared window that is sent for processing
     * @throws Exception is an exception in case the second window cannot be created
     */
    @Override
    public void start(Stage secondStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Second.class.getResource("second.fxml"));
        Scene scene = new Scene(loader.load(), 350, 550);
        secondStage.setTitle("FlashCards  session");
        secondStage.setResizable(false);
        secondStage.setScene(scene);
        secondStage.showAndWait();
    }

    /**
     * the beginning of the beginning
     * @param args is something sacred
     */
    public static void main(String[] args) { launch(); }

    /**
     * passes the prepared window for processing
     * @throws Exception is an exception in case the stage cannot be transmitted
     */
    public void showWindow() throws Exception {
        start(stage);
    }
}
