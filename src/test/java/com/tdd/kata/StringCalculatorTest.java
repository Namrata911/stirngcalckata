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
    @Test
    @DisplayName("Multiple-number-input separated by comma should return the sum")
    void multiNumInputShouldReturnSum(){
        assertAll("Testing for multiple number input",
                ()->assertEquals(6,stringcalc.add("1,2,3"),"Failed for input 1,2,3"),
                ()->assertEquals(415, stringcalc.add("15,100,200,100"),"failed for input 15,100,200,100")
        );
    }
    @Test
    @DisplayName("Allow new line delimiter or comma in input ")
    void newLineOrCommaDelimiter(){
        assertAll("Testing for new line or comma as delimiter in input",
                ()->assertEquals(3,stringcalc.add("1\n2"),"Failed for input 1\\n2"),
                ()->assertEquals(1303, stringcalc.add("1200\n100,1,2"),"failed for input 1200\\n100,1,2")
        );
    }
    @Test
    @DisplayName("Allow custom delimiter in input ")
    void customDelimiter(){
        assertAll("Testing for new line or comma as delimiter in input",
                ()->assertEquals(3,stringcalc.add("//;\n1;2"),"Failed for input //;\n1;2"),
                ()->assertEquals(1303, stringcalc.add("//@\n1200@100@1@2"),"failed for input //@\n1200@100@1@2")
        );
    }

}