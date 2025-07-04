package com.java.streamandlamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer>squares= numbers.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(squares);
    }
}
