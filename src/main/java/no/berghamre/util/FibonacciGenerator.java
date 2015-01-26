package no.berghamre.util;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.LongStream;
import java.util.stream.StreamSupport;

public class FibonacciGenerator implements PrimitiveIterator.OfLong {

  @Override
  /**
   *  return the next fibonacci number
   */
  public long nextLong() {
    return 0;
  }

  @Override
  /**
   * return false when next long overflows max long
   */
  public boolean hasNext() {
    return true;
  }


  public static LongStream fibonacci() {
    return StreamSupport.longStream(
        Spliterators.spliteratorUnknownSize(new FibonacciGenerator(), Spliterator.ORDERED | Spliterator.IMMUTABLE), false
    );
  }
}
