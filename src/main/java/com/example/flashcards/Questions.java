package com.example.flashcards;

public class Questions {

    private String answer;
    private String question;
    private boolean chosen = true;


    public Questions( String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }


    public String getQuestion() { return question;}

    public void setAnswer(String name) { //сеттер
        this.answer=name;
    }

    public void setQuestion(String name) { //сеттер
        this.question=name;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

}
