package com.example.flashcards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * tests for SecondController
 */
class SecondControllerTest {

    /**
     * test for readFile method
     */
    @Test
    void readFile() {
        SecondController sec = new SecondController();
        assertNotSame(sec.readFile(), null);
    }
}