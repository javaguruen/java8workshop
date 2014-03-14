package no.berghamre.util;

import org.junit.Test;

import java.util.stream.Collectors;

public class FibonacciGeneratorTest {
    @Test
    public void testInfiniteStream() throws Exception {
        FibonacciGenerator.infiniteStream().limit(10).forEach(System.out::println);//filter(l -> l<1000).forEach(System.out::println);
    }
}
