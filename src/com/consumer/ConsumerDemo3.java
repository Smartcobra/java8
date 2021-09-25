package com.consumer;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo3 {


    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,4,67,54,5);
        list.forEach(t->{
            System.out.println("print -:"+t);
        });
    }
}
