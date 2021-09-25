package com.consumer;


import java.util.function.Consumer;

public class ConsumerDemo1 implements Consumer<Integer> {
    @Override
    public void accept(Integer i) {
        System.out.println("Print--"+i);
    }

    public static void main(String[] args) {
        ConsumerDemo1 d= new ConsumerDemo1();
        d.accept(10);
    }
}
