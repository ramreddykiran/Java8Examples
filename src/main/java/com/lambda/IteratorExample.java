package com.lambda;

import java.util.stream.Stream;

public class IteratorExample {
    public static void main(String[] args) {
        IteratorExample ie = new IteratorExample();
        ie.limitM1();
    }

    private void limitM1() {
        Stream.iterate(0, n -> n + 3)
                .limit(10) // prints 10 numbers
                .forEach(e -> System.out.print(e + " "));


    }
}
