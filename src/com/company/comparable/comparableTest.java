package com.company.comparable;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class comparableTest {

    public static void main(String[] args) {
        Player p1 = new Player(15, "Rolando", 32);
        Player p2 = new Player(2, "Messi", 31);
        Player p3 = new Player(12, "Sunil", 33);

        List<Player> footBallTeam = new ArrayList<>();
        footBallTeam.add(p1);
        footBallTeam.add(p2);
        footBallTeam.add(p3);

        System.out.println("-before sorting" +footBallTeam);
        Collections.sort(footBallTeam);
        //if we are not implemting comparable interface in the player class
        //the error is -reason: no instance(s) of type variable(s) T exist so that Player conforms to Comparable<? super T>
        System.out.println("-After sorting" +footBallTeam);
    }


}
