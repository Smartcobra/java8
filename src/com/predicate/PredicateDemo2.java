package com.predicate;

import java.util.function.Predicate;

public class PredicateDemo2 {


    public static void main(String[] args) {
        Predicate<Integer> pd = (t) -> {
            if (t % 2 == 0) {
                return true;
            }
            return false;
        };

        System.out.println(pd.test(3));
    }
}
