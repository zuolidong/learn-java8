package io.github.biezhi.java8.stream.lesson2;

import lombok.AllArgsConstructor;

import java.util.stream.Stream;

public class Q01_0112358 {

    @AllArgsConstructor
    static class Tuple {
        int first;
        int second;
    }

    public static void main(String[] args) {

        Stream.iterate(new Tuple(0, 1), tuple -> new Tuple(tuple.second, tuple.first + tuple.second))
                .limit(20)
                .forEach(i -> System.out.println("(" + i.first + ", " + i.second + ")"));
    }
}
