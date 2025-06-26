package com.java.streamandlamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q4 {

    public static void main(String[] args) {
        List<String> names= Arrays.asList("kamal","amal","Namal");
        names.forEach(System.out::println);

        List<String>newNames   = names.stream().filter(x->x.startsWith("N")).collect(Collectors.toList());
        System.out.println(newNames);

    }
}
