package com.example.flashcards;

/**
 * it is a mock-up of questions and answers to them
 */
public class Questions {

    private String answer;
    private String question;
    private boolean chosen = true;

    /**
     * sets the question and answer for the given question
     * @param question is question for this question
     * @param answer is answer for this question
     */
    public Questions(String question, String answer) {
        this.answer = answer;
        this.question = question;
    }

    /**
     * returns answer for this question
     * @return answer for this question
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * returns question for this question
     * @return question for this question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * sets answer for this question
     * @param name is answer for this question
     */
    public void setAnswer(String name) {
        this.answer=name;
    }

    /**
     * sets question for this question
     * @param name is question for this question
     */
    public void setQuestion(String name) {
        this.question=name;
    }

    /**
     * returns a parameter chosen
     * @return a parameter chosen
     */
    public boolean isChosen() {
        return chosen;
    }

    /**
     * sets a parameter chosen
     * @param chosen is a parameter chosen for this question
     */
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

}
