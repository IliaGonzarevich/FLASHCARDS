package com.example.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FirstController {

    public static int countQ = 10;

    @FXML
    private Label errorNa;

    @FXML
    private TextField num;

    @FXML
    protected void showWindow() throws Exception {
        boolean isCorrect = true;
        if(num.getLength() > 0) {
            try {
                countQ = Integer.parseInt(num.getText());
                if (countQ < 1 || countQ > 30) isCorrect = false;
            } catch (NumberFormatException ne) {
                isCorrect = false;
            }
        }
        if(isCorrect) {
            num.clear();
            errorNa.setText("");
            Second second = new Second();
            second.showWindow();
        }
        else{
            errorNa.setText("Некоректные данные!\nМаксимальное количество вопросов 30");
        }
    }
}
