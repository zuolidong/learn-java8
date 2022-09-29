package io.github.biezhi.java8.stream.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q03 {
    public static void main(String[] args) {
        //q1();
        //q2();
        q3();
    }

    private static void q3() {
        List<Integer> numbers01 = Arrays.asList(1, 2, 3);
        List<Integer> numbers02 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers01.stream().flatMap(i -> numbers02.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));

    }

    private static void q1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> resultNumbers = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(resultNumbers);
    }

    private static void q2() {
        List<Integer> numbers01 = Arrays.asList(1, 2, 3);
        List<Integer> numbers02 = Arrays.asList(3, 4);

        List<int[]> pairs = numbers01.stream().flatMap(i -> numbers02.stream().map(j -> new int[]{j, j}))
                .collect(Collectors.toList());

        pairs.forEach(pair -> System.out.println(Arrays.toString(pair)));
    }
}
