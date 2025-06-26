package com.java.streamandlamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("kamal","amal","Namal");
        List<String> newNames=names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(newNames);
    }
}
