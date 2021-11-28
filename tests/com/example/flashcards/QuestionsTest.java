package com.example.flashcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for Questions
 */
class QuestionsTest {

    private final String question = "Is it?";
    private final String answer = "who is it";

    /**
     * test for getAnswer method
     */
    @Test
    void getAnswer() {
        Questions que = new Questions(question, answer);
        assertEquals("who is it", que.getAnswer());
    }

    /**
     * test for getQuestion method
     */
    @Test
    void getQuestion() {
        Questions que = new Questions(question, answer);
        assertEquals("Is it?", que.getQuestion());
    }

    /**
     * test for setAnswer method a little for getAnswer method
     */
    @Test
    void setAnswer() {
        Questions que = new Questions(question, "tests are shit");
        que.setAnswer(answer);
        assertEquals("who is it", que.getAnswer());
    }

    /**
     * test for setQuestion method a little for getQuestion method
     */
    @Test
    void setQuestion() {
        Questions que = new Questions("Yes, I agree with you, the coverage is utter shit", answer);
        que.setQuestion(question);
        assertEquals("Is it?", que.getQuestion());
    }

    /**
     * test for isChosen method and a little for setChosen method
     */
    @Test
    void isChosen() {
        Questions que = new Questions(question, answer);
        boolean isReal = que.isChosen();
        for (int i = 0; i < 3; i++){
            que.setChosen(!isReal);
        }
        assertFalse(que.isChosen());
    }

    /**
     * test for setChosen method and a little for isChosen method
     */
    @Test
    void setChosen() {
        Questions que = new Questions(question, answer);
        Questions que2 = new Questions("Just to be", "Yea, certainly");
        que.setChosen(false);
        assertNotEquals(que2.isChosen(), que.isChosen());
    }
}