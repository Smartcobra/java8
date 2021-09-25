package com.predicate;

import java.util.function.Predicate;


public class PredicateDemo implements Predicate<Integer> {

    @Override
    public boolean test(Integer i) {
        if (i % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PredicateDemo pd= new PredicateDemo();
        System.out.println(pd.test(4));
    }
}
