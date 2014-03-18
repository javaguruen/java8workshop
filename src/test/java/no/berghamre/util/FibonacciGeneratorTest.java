package no.berghamre.util;

import org.junit.Test;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import no.berghamre.util.fasit.FibonacciGenerator;

public class FibonacciGeneratorTest {
    @Test
    public void testInfiniteStream() throws Exception {
        FibonacciGenerator.fibonacci().limit(10).forEach(System.out::println);//filter(l -> l<1000).forEach(System.out::println);
    }

    Stream s = Stream.builder().add(1).add(2).add(3).build();
    IntStream positiveBelow100 = new Random(7).ints(1, 100);
    Stream s2 = Stream.iterate(3, s -> s+3);

    @Test
    public void testIterate() throws Exception {
        System.out.println(s2.limit(10).collect(Collectors.toList()));

    }
}
