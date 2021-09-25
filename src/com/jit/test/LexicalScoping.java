package com.jit.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LexicalScoping {
    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
                Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
                Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
        /*
         *     Find and count the names start with N,B,P
         * */
        long friendsStartWithN = friends.stream().filter(names -> names.startsWith("N")).count();
        long editorsStartWithN = editors.stream().filter(names -> names.startsWith("B")).count();
        long comradesStartsWithN = comrades.stream().filter(names -> names.startsWith("P")).count();
        /*
         * the problem here is the duplicate code -voilating DRY(Dont Repeat Yourself)
         * */
        final Predicate<String> startsWithN = names -> names.startsWith("N");
        /*
         * now we cant use this startsWithN predicate will not work.
         *
         * we have to write 3 predicates
         * */
        final Predicate<String> startsWithB = names -> names.startsWith("B");
        final Predicate<String> startsWithP = names -> names.startsWith("P");

/*      long countFriendsStartWithN=friends.stream().filter(startsWithN).count();
        long countEditorsStartWithB=editors.stream().filter(startsWithB).count();
        long countComradesStartsWithP=comrades.stream().filter(startsWithP).count();
        */

        /*
         * now we can leverage this in the above--
         * */
        long countFriendsStartWithN = friends.stream().filter(checkStartWith("N")).count();
        System.out.println(countFriendsStartWithN);
        long countEditorsStartWithB = editors.stream().filter(checkStartWith("B")).count();
        System.out.println(countEditorsStartWithB);
        long countComradesStartsWithP = comrades.stream().filter(checkStartWith("P")).count();
        System.out.println(countComradesStartsWithP);

       /*
       * new  consise code
       * */
        final Function<String,Predicate<String>> startWithLetter2=
                letter->name->name.startsWith(letter);

        long countFriendsStartWithN1 = friends.stream().filter(startWithLetter2.apply("N")).count();
        System.out.println(countFriendsStartWithN);
        long countEditorsStartWithB1 = editors.stream().filter(startWithLetter2.apply("B")).count();
        System.out.println(countEditorsStartWithB);
        long countComradesStartsWithP1= comrades.stream().filter(startWithLetter2.apply("P")).count();
        System.out.println(countComradesStartsWithP);

    }

    /*
     * This should be a static method as we invoking in lambda
     * */
    public static Predicate<String> checkStartWith(String letter) {
        return name -> name.startsWith(letter);
    }

    /*
     * This static method , again a problem
     *
     * can be refactor as
     * */
    final Function<String, Predicate<String>> startWith =
            (String letter) -> {
                Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                return checkStarts;
            };

    /*
     * Can be further reduce to
     * */
    final Function<String,Predicate<String>> startWithLetter=
            (String letter)->(String name)->name.startsWith(letter);

    /*
     * Can be further reduce to
     * */

    final Function<String,Predicate<String>> startWithLetter2=
             letter->name->name.startsWith(letter);

}
