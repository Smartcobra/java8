package com.consumer;


import java.util.function.Consumer;

public class ConsumerDemo2  {


    public static void main(String[] args) {
        Consumer c= t->{
            System.out.println("print--:"+t);
        };

        c.accept(10);
    }
}
