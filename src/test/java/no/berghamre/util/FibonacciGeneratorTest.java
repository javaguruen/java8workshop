package no.berghamre.util;

import org.junit.Assert;
import org.junit.Test;


public class FibonacciGeneratorTest {

  @Test
  public void testInfiniteStream() throws Exception {
    long[] fibs = FibonacciGenerator.fibonacci().limit(10).toArray();
    Assert.assertArrayEquals(new long[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, fibs);
  }
}
