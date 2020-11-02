package com.tdd.kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private static StringCalculator stringcalc;

    @BeforeAll
    public static void init(){
        stringcalc = new StringCalculator();
    }


    @Test
    @DisplayName("Empty string input should return zero")
    void emptyInputShouldReturnZero(){
        assertAll("Testing for Null, Empty, and Blank input",
                ()->assertEquals(0,stringcalc.add(""),"Failed for empty input"),
                ()->assertEquals(0, stringcalc.add(null),"failed for null input"),
                ()-> assertEquals(0,stringcalc.add(" "),"Failed for whitespace"));
    }

}