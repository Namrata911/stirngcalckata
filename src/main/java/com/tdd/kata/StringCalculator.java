package com.tdd.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        return calculateSum(split);
    }

    /**
     * Method to return sum or throw exception for negative numbers in input
     * @throws NegativeInputException for negative numbers in input
     * @return sum
     */
    private int calculateSum(String[] numbers){
        List<Integer> negatives = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(value -> value < 0)
                .boxed()
                .collect(Collectors.toList());

        if(negatives.size()>0){
            StringBuilder sb = new StringBuilder();
            for(int negative : negatives){
                sb.append(negative+", ");
            }
            throw new NegativeInputException("Negative numbers in input: "+ sb.toString());
        }

        int sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();

        return sum;
    }

}
