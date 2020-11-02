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
    @Test
    @DisplayName("Single number input should return the number")
    void singleInputShouldReturnSame(){
        assertAll("Testing for single input",
                ()->assertEquals(1,stringcalc.add("1"),"Failed for input 1 "),
                ()->assertEquals(15, stringcalc.add("15"),"failed for input 15"),
                ()->assertEquals(1200, stringcalc.add("1200"),"failed for input 1200")
                );
    }
    @Test
    @DisplayName("Two number input separated by comma should return the sum")
    void twoNumInputShouldReturnSum(){
        assertAll("Testing for two number input",
                ()->assertEquals(3,stringcalc.add("1,2"),"Failed for input 1,2"),
                ()->assertEquals(115, stringcalc.add("15,100"),"failed for input 15,100"),
                ()->assertEquals(1300, stringcalc.add("1200,100"),"failed for input 1200,100")
        );
    }

}