package com.example.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.Objects;
import java.util.Random;

public class SecondController {

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
    private AnchorPane results;

    @FXML
    private Label resultLbl;

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

    void changeBackground(Label lbl, String clr, String bckRad, String brad, String bWth) {
        lbl.setStyle("-fx-background-color: " + clr + "; -fx-background-radius: 0 0 " + bckRad + "; -fx-border-radius: 0 0 " + brad + "; -fx-border-color: grey; -fx-border-width: 1 1 1 " + bWth + ";");
    }

    private int num = questions.length;
    private int statistic = 0;
    private int n;

    private Random random = new Random();

    void rand3() {

        String[] masN = new String[4];

        for (int i = 0; i<masN.length; i++){

            n = random.nextInt(num);


            masN[i]=questions[n].getAnswer();
        }

        int num1 = 3;
        for (int i = 0; i<masN.length; i++) {
            int k = random.nextInt(4);
            String obMen = masN[k];
            masN[k] = masN[num1];
            masN[num1] = obMen;
            num1 = k;
        }

        radio1.setText(masN[0]);
        radio2.setText(masN[1]);
        radio3.setText(masN[2]);
        radio4.setText(masN[3]);

        lblQ.setText(questions[n].getQuestion());
        lblA.setText(questions[n].getAnswer());
    }

    void rand2(){

        Questions x;
        x = questions[n];

        questions[n] = questions[num-1];

        questions[num-1] = x;
    }
    @FXML
    void initialize() {

        radioVertical.setVisible(false);

        lblShow2.setVisible(false);

        results.setVisible(false);

        labelHideA.setOnMouseEntered(event -> labelHideA.setText("Ответ: " + questions[n].getAnswer()));
        labelHideA.setOnMouseExited(event -> labelHideA.setText("Ну ладно, если прям не помнишь, посмотри уже"));

        lblY.setOnMouseEntered(event -> changeBackground(lblY, "green", "0 20", "0 20", "1"));
        lblY.setOnMouseExited(event -> changeBackground(lblY, "white", "0 20", "0 20", "1"));

        lblN.setOnMouseEntered(event -> changeBackground(lblN, "grey", "20 0", "20 0", "0"));
        lblN.setOnMouseExited(event -> changeBackground(lblN, "white", "20 0", "20 0", "0"));

        if (!radioVertical.isVisible()) {
   
            rand3();

            lblA.setVisible(false);
            sep.setVisible(false);

            lblShow.setOnMousePressed(show -> {
                sep.setVisible(true);
                lblShow.setVisible(false);
                lblA.setVisible(true);
                variantLbl.setVisible(false);
            });


            lblY.setOnMousePressed(event -> {

                rand2();
                num--;

                if (num == 0) {
                    hideVB.setVisible(false);
                    hideTop.setVisible(false);
                    hideBottom.setVisible(false);
                    results.setVisible(true);
                    variantLbl.setVisible(false);
                    resultLbl.setText(Integer.toString(statistic));
                } else {
                    sep.setVisible(false);
                    pBar.setProgress(pBar.getProgress() + 0.05);
                    rand3();
                    lblShow.setVisible(true);
                    lblQ.setText(questions[n].getQuestion());
                    lblA.setVisible(false);
                    lblA.setText(questions[n].getAnswer());
                    variantLbl.setVisible(true);
                }
            });

            lblN.setOnMousePressed(event -> {

                if (questions[n].isChoosen()) {
                    questions[n].setChoosen(false);
                    statistic++;
                }

                if (num == 0) {
                    hideVB.setVisible(false);
                    hideTop.setVisible(false);
                    hideBottom.setVisible(false);
                    results.setVisible(true);
                    variantLbl.setVisible(false);
                    resultLbl.setText(Integer.toString(statistic));
                } else {
                    rand3();
                    sep.setVisible(false);
                    lblShow.setVisible(true);
                    lblA.setVisible(false);
                    variantLbl.setVisible(true);
                }

            });
        }

        variantLbl.setOnMousePressed(mouseEvent -> {
          
            if (radioVertical.isVisible()) {
                
                radioVertical.setVisible(false);
                lblShow2.setVisible(false);
                lblShow.setVisible(true);

                lblA.setVisible(false);
                sep.setVisible(false);

                lblShow.setOnMousePressed(show2 -> {
                    
                    sep.setVisible(true);
                    lblShow.setVisible(false);
                    lblA.setVisible(true);
                    variantLbl.setVisible(false);
                });


                lblY.setOnMousePressed(event -> {
                   

                    rand2();
                    num--;

                    if (num == 0) {
                        hideVB.setVisible(false);
                        hideTop.setVisible(false);
                        hideBottom.setVisible(false);
                        results.setVisible(true);
                        variantLbl.setVisible(false);
                        resultLbl.setText(Integer.toString(statistic));
                    } else {
                        sep.setVisible(false);
                        pBar.setProgress(pBar.getProgress() + 0.05);
                        rand3();
                        lblShow.setVisible(true);
                        lblA.setVisible(false);
                        variantLbl.setVisible(true);
                    }
                });

                lblN.setOnMousePressed(event -> {

                    if (questions[n].isChoosen()) {
                        questions[n].setChoosen(false);
                        statistic++;
                    }

                    if (num == 0) {
                        hideVB.setVisible(false);
                        hideTop.setVisible(false);
                        hideBottom.setVisible(false);
                        results.setVisible(true);
                        variantLbl.setVisible(false);
                        resultLbl.setText(Integer.toString(statistic));
                    } else {
                        rand3();
                        sep.setVisible(false);
                        lblShow.setVisible(true);
                        lblA.setVisible(false);
                        variantLbl.setVisible(true);
                        lblShow2.setVisible(false);
                    }

                });
            }
            else{
                
                sep.setVisible(true);
                radioVertical.setVisible(true);
                lblShow2.setVisible(true);
                lblShow.setVisible(false);



                lblY.setOnMousePressed(event1 -> {
                    
                    rand2();
                    num--;

                        if (num == 0) {
                            hideVB.setVisible(false);
                            hideTop.setVisible(false);
                            hideBottom.setVisible(false);
                            results.setVisible(true);
                            variantLbl.setVisible(false);
                            resultLbl.setText(Integer.toString(statistic));
                        } else {
                            sep.setVisible(false);
                            pBar.setProgress(pBar.getProgress() + 0.05);
                            lblShow.setVisible(true);
                            rand3();
                            lblA.setVisible(false);
                            variantLbl.setVisible(true);
                            radioVertical.setVisible(false);
                            lblShow2.setVisible(false);
                        }
                    });
                    lblN.setOnMousePressed(event3 -> {
                      
                        if (questions[n].isChoosen()) {
                            questions[n].setChoosen(false);
                            statistic++;
                        }

                        if (num == 0) {
                            hideVB.setVisible(false);
                            hideTop.setVisible(false);
                            hideBottom.setVisible(false);
                            results.setVisible(true);
                            variantLbl.setVisible(false);
                            resultLbl.setText(Integer.toString(statistic));
                        } else {
                            rand3();
                            sep.setVisible(false);
                            lblShow.setVisible(true);
                            lblA.setVisible(false);
                            variantLbl.setVisible(true);
                            radioVertical.setVisible(false);
                            lblShow2.setVisible(false);
                        }
                    });

                lblShow2.setOnMousePressed(event -> {
                   
                    RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
                    if (selectedRadio != null) {
                        String toggleGroupValue = selectedRadio.getText();
                        if (!Objects.equals(toggleGroupValue, lblA.getText())) {statistic++;}
                        sep.setVisible(true);
                        lblA.setVisible(true);
                        radioVertical.setVisible(false);
                        lblShow2.setVisible(false);
                        variantLbl.setVisible(false);
                        lblY.setVisible(true);
                        lblN.setVisible(true);
                    }
                });
            }


        });


    }
}
