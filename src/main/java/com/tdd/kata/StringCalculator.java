package com.tdd.kata;

import java.util.Arrays;

public class StringCalculator {
    /**
     * returns addition of numbers passed in a string separated by delimiter
     * @param numbers input string
     * @return sum
     */
    public int add(String numbers){
        if(numbers==null || numbers.isEmpty() || numbers.isBlank()){
            return 0;
        }

        //default delimiter
        String delimiter="[,\n]";
        if(numbers.startsWith("//")){
            delimiter = numbers.substring(2,numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n")+1);
        }

        String[] split = numbers.split(delimiter);
        if(split.length==1){
            return Integer.parseInt(split[0]);
        }
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();

    }

}
