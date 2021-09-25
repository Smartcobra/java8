package com.predicate;

import java.util.function.Predicate;

public class PredicateDemo3 {


    public static void main(String[] args) {
       // Predicate<Integer> pd = (t) -> (t%2==0);
        Predicate<Integer> pd = (t -> t%2==0);

        System.out.println(pd.test(4));
    }
}
