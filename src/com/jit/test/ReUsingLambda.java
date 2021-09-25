package com.jit.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ReUsingLambda {
    public static void main(String[] args) {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors =
                Arrays.asList("Brian", "Jackie", "John", "Mike");
        final List<String> comrades =
                Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
   /*
   *     Find and count the names start with N
   * */
        long friendsStartWithN = friends.stream().filter(names -> names.startsWith("N")).count();
        long editorsStartWithN = editors.stream().filter(names -> names.startsWith("N")).count();
        long comradesStartsWithN = comrades.stream().filter(names -> names.startsWith("N")).count();
           /*
           * the problem here is the duplicate code -voilating DRY(Dont Repeat Yourself)
           * */
        final Predicate<String> startsWithN= names -> names.startsWith("N");
        long countFriendsStartWithN=friends.stream().filter(startsWithN).count();
        long countEditorsStartWithN=editors.stream().filter(startsWithN).count();
        long countComradesStartsWithN=comrades.stream().filter(startsWithN).count();

    }
}
