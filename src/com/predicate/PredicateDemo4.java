package com.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo4 {

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8);
        //Predicate<Integer> pd= (t-> t%2==0);
        //list.stream().filter(pd).forEach(t->System.out.println("Even::"+t));
        list.stream().filter(t-> t%2==0).forEach(t->System.out.println("Even::"+t));


    }
}
