package in.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in the year 2011 and sort them by value (small to high).
        //find all transaction in the year 2011.
        List<Transaction> transactionList2011 = transactions.stream().filter(t -> t.getYear() == 2011).collect(Collectors.toList());
        //System.out.println(transactionList2011);
       // sort them by value (small to high)
        List<Transaction> collect = transactions.stream().filter(t -> t.getYear() == 2011).
                                                          sorted(Comparator.comparing(Transaction::getValue)).
                                                          collect(Collectors.toList());
       // System.out.println(collect);

        // sort them by value (high to small)
        List<Transaction> collectReverse = transactions.stream().filter(t -> t.getYear() == 2011).
                sorted(Comparator.comparing(Transaction::getValue).reversed()).
                collect(Collectors.toList());
        //System.out.println(collectReverse);

        //What are all the unique cities where the traders work?
        Set<String> city = transactions.stream().map(t -> t.getTrader().getCity()).collect(Collectors.toSet());
        System.out.println(city);

        boolean cambridge = transactions.stream().map(t -> t.getTrader().getCity()).equals("Cambridge");

//                .distinct()
//                .sorted(Comparator.comparing(Trader::getName))
//                .collect(Collectors.toSet());

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t->t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        String reduce = transactions.stream()  //making stream of transactions
                .map(t -> t.getTrader().getName()) //mapping to stream of string with name
                .distinct() // removes duplicate
                .sorted() // natural sorting
                .reduce("", (n1, n2) -> n1 + n2);  // combines name one by one to from a string
        System.out.println(reduce);

        String names = transactions.stream()  //making stream of transactions
                .map(t -> t.getTrader().getName()) //mapping to stream of string with name
                .distinct() // removes duplicate
                .sorted() // natural sorting
                .collect(Collectors.joining());  // combines name one by one to from a string using a Sting Builder
        System.out.println(names);

        ///are any traders based in Milan?
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milan);

        transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> max = transactions.stream().map(Transaction::getValue)
                .reduce(Integer::max);

        Optional<Transaction> min = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);

    }
}
