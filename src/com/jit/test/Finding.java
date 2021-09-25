package com.jit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Finding {
    public static void main(String[] args) {
        final List<String> friends= Arrays.asList("ram","sam","amit","asit","hari","siya","jitu","jak","mike");
          List<String> namesStartWithA= new ArrayList<>();
          for (int i=0;i<friends.size();i++){
              if(friends.get(i).startsWith("A")){
                  namesStartWithA.add(friends.get(i));
              }
          }

        for (String names:friends){
            if(names.startsWith("A")){
                namesStartWithA.add(names);
            }
        }


        List<String> startWithA = friends.stream().filter(names -> names.startsWith("A")).collect(Collectors.toList());
        System.out.println(String.format("Found %d names", startWithA.size()));
    }
}
