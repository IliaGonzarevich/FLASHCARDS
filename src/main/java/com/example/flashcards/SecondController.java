package com.example.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.security.SecureRandom;
import java.util.Objects;

public class SecondController {

    @FXML
    private TextArea wrongVarQ;

    @FXML
    private TextArea wrongQ;

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
            new Questions("матрица", "прямоугольная таблица размером m x n\nсодержащая m строк и n столбцов"),
            new Questions("матрица-строка (вектор-строка)", "матрица, содержащая одну строку"),
            new Questions("матрица-столбец (вектор-столбец)", "матрица, содержащая один столбец"),
            new Questions("квадратная матрица", "матрица, число строк которой равно\nчислу столбцов, т.е. m=n"),
            new Questions("транспонированная матрица", "матрица, получившаяся в результате\nперестановки каждой строки некой матрицы\nв столбцы этой матрицы в том же порядке"),
            new Questions("минор", "определитель aij порядка n−1 матрицы An,\nполученный из определителя этой же\nматрицы после вычеркивания в ней\ni-той строки и j-ого столбца"),
            new Questions("алгебраическое дополнение матрицы", "число Aij=(−1)^(i+j) * Mij,\nгде Mij — дополнительный минор"),
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
    String[] variantMas = new String[20];

    private int num = questions.length;
    private int badStat = 0;
    private int rightStat = 0;
    private int varStatF = 0;
    private int isTina;
    private boolean isVar = false;
    int[] masN;
    SecureRandom random = new SecureRandom();

    void rand3() {
        masN = new int[4];
        int j;
        int n;
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

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    void doLblShow(){
        lblShow.setOnMousePressed(show -> {
            sep.setVisible(true);
            lblShow.setVisible(false);
            lblA.setVisible(true);
            variantLbl.setVisible(false);
        });
    }

    void queViVod(){
        if(badStat == 0) {
            wrongQ.setText("Вы ответили верно на все вопросы!\nПоздравляем!");
        } else {
            wrongQ.setText("В процессе вы выучили следующие термины:\n");
            String pred;
            for (int i = 0; i < 20; i++) {
                if (!questions[i].isChosen()) {
                    pred = wrongQ.getText();
                    wrongQ.setText(pred + questions[i].getQuestion() + "\n");
                }
            }
        }
        if(varStatF == 0) {
            wrongVarQ.setText("Вы ответили верно на все вопросы,\nс испозованием вариантов ответа!\nВы молодец!");
        } else {
            wrongVarQ.setText("С использованием вариантов ответа, вы ответили\nневерно на следующие вопросы:\n");
            for (int i = 0; i < varStatF; i++) {
                String predVar = wrongVarQ.getText();
                wrongVarQ.setText(predVar + variantMas[i] + "\n");
            }
        }
    }
    void doLblY(boolean isVarR){
        lblY.setOnMousePressed(event -> {
            rand2();
            num--;
            rightStat++;
            String conclusion;
            if (isBetween(rightStat, 2, 4)) {
                conclusion = " термина";
            } else if (isBetween(rightStat, 5, 20)) {
                conclusion = " терминов";
            } else conclusion = " термин";
            learn.setText("Вы выучили " + rightStat + conclusion);

            if (num == 0) {
                hideVB.setVisible(false);
                hideTop.setVisible(false);
                hideBottom.setVisible(false);
                variantLbl.setVisible(false);
                resultAnchorPane.setVisible(true);
                if(isVarR){
                    radioVertical.setVisible(false);
                    sep.setVisible(false);
                    lblShow2.setVisible(false);
                }
                queViVod();
            } else {
                rand3();
                lblA.setVisible(false);
                pBar.setProgress(pBar.getProgress() + 0.05);
                sep.setVisible(false);
                lblShow.setVisible(true);
                variantLbl.setVisible(true);
                if(isVarR){
                    variantLbl.setText(" Добавить варианты ответа");
                    radioVertical.setVisible(false);
                    lblShow2.setVisible(false);
                }
            }
        });
    }

    void doLblN(boolean isVarR){
        lblN.setOnMousePressed(event -> {
            if (questions[isTina].isChosen()) {
                questions[isTina].setChosen(false);
                badStat++;
                dontKnow.setText(String.valueOf(badStat));
            }
            rand3();
            sep.setVisible(false);
            lblShow.setVisible(true);
            lblA.setVisible(false);
            variantLbl.setVisible(true);
            lblShow2.setVisible(false);
            if(isVarR) {
                variantLbl.setText(" Добавить варианты ответа");//это
                radioVertical.setVisible(false);//это
            }
        });
    }

    int variantK = -1;
    @FXML
    void show2Pressed(){
        RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
        if (selectedRadio != null) {
            String toggleGroupValue = selectedRadio.getText();
            if (!Objects.equals(toggleGroupValue, lblA.getText()) && questions[isTina].isChosen()) {
                variantK++;
                variantMas[variantK] = questions[isTina].getQuestion();
                varStatF++;
                varKnow.setText(String.valueOf(varStatF));
            }
            sep.setVisible(true);
            lblA.setVisible(true);
            radioVertical.setVisible(false);
            lblShow2.setVisible(false);
            variantLbl.setVisible(false);
            lblY.setVisible(true);
            lblN.setVisible(true);
            selectedRadio.setSelected(false);
        }
    }

    @FXML
    void variantPressed(){
        isVar = true;
        if (radioVertical.isVisible()) {
            variantLbl.setText("  Добавить варианты ответа");
            radioVertical.setVisible(false);
            lblShow2.setVisible(false);
            lblShow.setVisible(true);
            lblA.setVisible(false);
            sep.setVisible(false);
        }
        else{
            sep.setVisible(true);
            radioVertical.setVisible(true);
            lblShow2.setVisible(true);
            lblShow.setVisible(false);
            variantLbl.setText("    Убрать варианты ответа");
        }
        doLblY(isVar);
        doLblN(isVar);
        RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
        if (selectedRadio != null) {
            selectedRadio.setSelected(false);
        }
    }

    @FXML
    void showWrongQ(){
        wrongQ.setVisible(true);
    }

    @FXML
    void hideWrongQ(){
       wrongQ.setVisible(false);
    }

    @FXML
    void showWrongVarQ(){
        wrongVarQ.setVisible(true);
    }

    @FXML
    void hideWrongVarQ(){
        wrongVarQ.setVisible(false);
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
        wrongVarQ.setVisible(false);
        wrongVarQ.setStyle("-fx-focus-traversable: false");
        wrongQ.setVisible(false);//добавил
        wrongQ.setStyle("-fx-focus-traversable: false");
        resultAnchorPane.setVisible(false);
        radioVertical.setVisible(false);
        lblShow2.setVisible(false);
        lblA.setVisible(false);
        sep.setVisible(false);
        doLblShow();
        doLblY(isVar);
        doLblN(isVar);
    }

}
