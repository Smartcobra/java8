package com.jit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transforming {
    public static void main(String[] args) {
        final List<String> friends= Arrays.asList("ram","sam","amit","asit","hari","siya","jitu","jak","mike");

        /*
        * transfer to uppercase
        * */
        List<String> upperFriends= new ArrayList<>();
        for(int i=0;i<friends.size();i++){
            upperFriends.add(friends.get(i).toUpperCase());
        }

        for (String name:friends){
            upperFriends.add(name.toUpperCase());
        }
      /*
      * here we use internal iterator but still use another list to store data.
      * */
        friends.forEach(names->upperFriends.add(names.toUpperCase()));
        friends.forEach(names-> System.out.print(names.toUpperCase()+" "));
        System.out.println();
        friends.stream()
                .map(name->name.toUpperCase())
                .forEach(name-> System.out.print(name+" "));
        System.out.println();


        /*
        * length
        * */
        friends.stream()
                .map(name->name.length())
                .forEach(nameLength-> System.out.print(nameLength));
        System.out.println();
    }


}
