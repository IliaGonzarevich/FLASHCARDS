package com.example.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.Random;

public class SecondController {

    @FXML
    private Label varKnow;

    @FXML
    private Label dontKnow;

    @FXML
    private Label learn;

    @FXML
    private AnchorPane resultAnchorPane;

    @FXML
    private Label lblShow2;

    @FXML
    private Label variantLbl;

    @FXML
    private VBox radioVertical;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private AnchorPane hideBottom;

    @FXML
    private VBox hideVB;

    @FXML
    private AnchorPane hideTop;

    @FXML
    private Separator sep;

    @FXML
    private Label lblShow;

    @FXML
    private Label lblA;

    @FXML
    private Label lblY;

    @FXML
    private Label lblN;

    @FXML
    private Label lblQ;

    @FXML
    private Label labelHideA;

    @FXML
    private ProgressBar pBar;




    Questions[] questions = new Questions[]{
            new Questions("матрица", "матрицей A размера m×n\nназывается прямоугольная таблица\nсодержащая m строк и n столбцов"),
            new Questions("матрица-строка (вектор-строка)", "матрица, содержащая одну строку,\nназывается матрицей-строкой\nили вектором-строкой."),
            new Questions("матрица-столбец (вектор-столбец)", "матрица, содержащая один столбец,\nназывается матрицей-столбцом\nили вектором-столбцом"),
            new Questions("4?", "4"),
            new Questions("5?", "5"),
            new Questions("6?", "6"),
            new Questions("7?", "7"),
            new Questions("8?", "8"),
            new Questions("9?", "9"),
            new Questions("10?", "10"),
            new Questions("11?", "11"),
            new Questions("12?", "12"),
            new Questions("13?", "13"),
            new Questions("14?", "14"),
            new Questions("15?", "15"),
            new Questions("16?", "16"),
            new Questions("17?", "17"),
            new Questions("18?", "18"),
            new Questions("19?", "19"),
            new Questions("20?", "20")
    };


    private int num = questions.length;
    private int badStat = 0;
    private int rightStat = 0;
    private int varStatF = 0;
    private int isTina;
    private boolean isVar = false;
    int[] masN;
    Random random = new Random();


    void rand3() {
        masN = new int[4];
        int j, n;
        n = random.nextInt(num);
        masN[0] = n;
        isTina = n;
        for (int i = 1; i < masN.length; i++) {
            j = 0;
            n = random.nextInt(20);
            while (j < i) {
                if (masN[j] == n) {
                    n = random.nextInt(20);
                    j = 0;
                } else {
                    j++;
                }
            }
            masN[i] = n;
        }
        putPrVAnswer(masN);
        String[] variantMas = new String[4];
        for (int ch = 0; ch < variantMas.length; ch++) {
            variantMas[ch] = questions[masN[ch]].getAnswer();
            System.out.println(variantMas[ch]);
        }
        radio1.setText(variantMas[0]);
        radio2.setText(variantMas[1]);
        radio3.setText(variantMas[2]);
        radio4.setText(variantMas[3]);
        lblQ.setText(questions[isTina].getQuestion());
        lblA.setText(questions[isTina].getAnswer());
    }

    void putPrVAnswer(int[] massive) {
        int num1 = 0;
        int obMen;
        for (int i = 0; i < massive.length; i++) {
            int k = random.nextInt(4);
            obMen = massive[k];
            massive[k] = massive[num1];
            massive[num1] = obMen;
            num1 = k;
        }
    }

    void rand2() {
        Questions x;
        x = questions[isTina];
        questions[isTina] = questions[num - 1];
        questions[num - 1] = x;
    }

    @FXML
    void variantPressed(){

    }

    @FXML
    void show2Pressed(){

    }

    void changeBackground(Label lbl, String clr, String bckRad, String brad, String bWth) {
        lbl.setStyle("-fx-background-color: " + clr + "; -fx-background-radius: 0 0 " + bckRad + "; -fx-border-radius: 0 0 " + brad + "; -fx-border-color: grey; -fx-border-width: 1 1 1 " + bWth + ";");
    }

    @FXML
    void lblYOnEntered() {
        changeBackground(lblY, "green", "0 20", "0 20", "1");
    }

    @FXML
    void lblYOnExited() {
        changeBackground(lblY, "white", "0 20", "0 20", "1");
    }

    @FXML
    void lblNOnEntered() {
        changeBackground(lblN, "grey", "20 0", "20 0", "0");
    }

    @FXML
    void lblNOnExited() {
        changeBackground(lblN, "white", "20 0", "20 0", "0");
    }

    @FXML
    void hideAOnEntered() {
        labelHideA.setText("Ответ: " + questions[isTina].getAnswer());
    }

    @FXML
    void hideAOnExited() {
        labelHideA.setText("Наведи, чтобы увидеть часть ответа");
    }
    @FXML
    void initialize() {
        rand3();
        resultAnchorPane.setVisible(false);
        radioVertical.setVisible(false);
        lblShow2.setVisible(false);
        lblA.setVisible(false);
        sep.setVisible(false);
    }

}
