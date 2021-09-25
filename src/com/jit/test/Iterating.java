package com.jit.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iterating {
    public static void main(String[] args) {
        final List<String> friends= Arrays.asList("ram","sam","amit","asit","hari","siya","jitu","jak","mike");

        /*
         this is useful only if we need to manipulate the particular index.
         here we are mutating the object.
        * */
        System.out.println("--------FIRST------------");
        for(int i=0;i<friends.size();i++){
            System.out.println(friends.get(i));
        }

        /*
        * this form of iteration uses the Iterator interface and calls into its hasNext() and next() methods*/
        System.out.println("--------SECOND------------");
        for(String names:friends){
            System.out.println(names);
        }
        /*
         the above code breaks the design "Tell.dont Ask".
        * */
        /*
        * Now comes to forEach.. the internal iterator
        * */
        System.out.println("--------THIRD------------");
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("--------FOURTH------------");
        friends.forEach(s-> System.out.println(s));

        System.out.println("--------SIX------------");
        friends.forEach(System.out::println);
    }

}
