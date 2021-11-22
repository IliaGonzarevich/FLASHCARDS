package com.example.flashcards;

public class Questions {

    private final String answer;
    private final String question;
    private boolean chosen = true;


    public Questions( String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }


    public String getQuestion() { return question;}


    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}
