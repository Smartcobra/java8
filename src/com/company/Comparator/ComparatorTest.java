package com.company.Comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        Player p1 = new Player(15, "Pant", 23);
        Player p2 = new Player(2, "smith", 31);
        Player p3 = new Player(1, "kohli", 33);

        List<Player> cricketTeam = new ArrayList<>();
        cricketTeam.add(p1);
        cricketTeam.add(p2);
        cricketTeam.add(p3);

        System.out.println("-before sorting" + cricketTeam);
        Comparator cricketComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.getRanking() >o2.getRanking()){
                    return 1;
                }else
                    return -1;
            }
        };
        Collections.sort(cricketTeam,cricketComparator);
        //if we are not implemting comparable interface in the player class
        //the error is -reason: no instance(s) of type variable(s) T exist so that Player conforms to Comparable<? super T>
        System.out.println("-After sorting" + cricketTeam);
    }
}
