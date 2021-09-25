package com.company.compator8;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        Player p1 = new Player(15, "Pant", 23);
        Player p2 = new Player(2, "smith", 31);
        Player p3 = new Player(1, "ff", 33);

        List<Player> cricketTeam = new ArrayList<>();
        cricketTeam.add(p1);
        cricketTeam.add(p2);
        cricketTeam.add(p3);

        System.out.println("-before sorting" + cricketTeam);
    /*    Comparator cricketComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.getRanking() >o2.getRanking()){
                    return 1;
                }else
                    return -1;
            }
        };*/
        Comparator <Player> byRanking = ( player1, player2 ) ->
                Integer.compare(player1.getRanking(), player2.getRanking());
        Comparator comp=Comparator.comparing(Player::getRanking);
        Collections.sort(cricketTeam,comp);
        System.out.println("-After sorting" + cricketTeam);
    }
}
