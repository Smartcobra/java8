package com.functionalProgramming;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;

import java.util.*;

public class Solution
{
    public static void main(String[] args){

           List<Person> list= new ArrayList<>();
           Person p1= new Person(2,"ram");
           Person p2= new Person(3,"sam");
           Person p3= new Person(5,"lam");

           list.add(p1);
           list.add(p2);
           list.add(p3);

        Person person = list.stream().max(Comparator.comparing(Person::getAge)).orElseThrow(NoSuchElementException::new);
        System.out.println(person);

        char charArray[] = { 'c','a',0,0,0,0};
        String s4 = new String(charArray, 0, 2);

        System.out.println(s4);

    }
}
