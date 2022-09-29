package io.github.biezhi.java8.stream.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q05_ {

    /**
     * 交易员
     */
    @Data
    @AllArgsConstructor
    static class Trader {
        private String name;
        private String city;
    }

    /**
     * 交易信息
     */
    @Data
    @AllArgsConstructor
    static class Transaction {
        private Trader trader;
        private int year;
        private int value;
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridage");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridage");
        Trader brian = new Trader("Brian", "Cambridage");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        System.out.println("______01______");
// * (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        transactions.stream().filter(t->t.getYear()==2011).
                sorted(Comparator.comparing(Transaction::getValue)).
                collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("______02______");
// * (2) 交易员都在哪些不同的城市工作过？
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity)
                .distinct().forEach(System.out::println);
        System.out.println("______03______");


// * (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream().map(Transaction::getTrader).
                filter(trader -> "Cambridage".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                        .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("______04______");
// * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct()
                        .sorted(Comparator.naturalOrder())
                                .collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("______05______");
// * (5) 有没有交易员是在米兰工作的？
        transactions.stream().map(transaction -> transaction.getTrader())
                        .filter(trader -> "Milan".equals(trader.getCity()))
                .distinct()
                                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("______06______");
// * (6) 打印生活在剑桥的交易员的所有交易额。
        System.out.println(transactions.stream().filter(transaction -> "Cambridage".equals(transaction.getTrader().getCity()))
                        .map(Transaction::getValue)
                .reduce(0, Integer::sum));
        System.out.println("______07______");
// * (7) 所有交易中，最高的交易额是多少？
        System.out.println(transactions.stream().mapToInt(Transaction::getValue).max());
        System.out.println("______08______");
// * (8) 找到交易额最小的交易。
        System.out.println(transactions.stream().mapToInt(Transaction::getValue).min());
        System.out.println(transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2));
    }
}
