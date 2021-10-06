package com.predicate;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo5 {

    public static  <T>List<T> filter(List<T> list,Predicate<T> p){
             List<T> results= new ArrayList<T>();
             for(T t:list){
                 if (p.test(t)){
                     results.add(t);
                 }
             }
             return results;
    }

    public static void main(String[] args) {
        List<String> strings= new ArrayList<>();
        strings.add("sam");
        strings.add("ram");
        strings.add("");
        strings.add("hari");
        Predicate<String>  nonEmptyString = (item -> !item.isEmpty());
        List<String> nonEmpty = filter(strings, nonEmptyString);
       nonEmpty.forEach(t-> System.out.print(t+","));
        System.out.println();
        //System.out.println(nonEmptyString.test(""));

        List<String> collect = strings.stream().filter(item -> !item.isEmpty()).collect(Collectors.toList());
        //collect.forEach(t-> System.out.print(t+","));
    }


}
