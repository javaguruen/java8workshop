package no.berghamre.util;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03BonusImpl implements Exercises03Bonus {

  /**
   * Hint: always start with "1"  next is "11", "21", "1211" ...
   * Hint: implement helper method below first
   * see: http://en.wikipedia.org/wiki/Look-and-say_sequence
   */
  @Override public Stream<String> lookAndSay() {
    return Stream.<String>empty();
  }

  @Override public LongStream fibonacci() {
    return no.berghamre.util.FibonacciGenerator.fibonacci();
  }

  /**
   * Helper for lookAndSay. Tip: make this recursive
   *
   * @param digits current digits
   * @param prev previous digit
   * @param curlen current length of equal digits
   * @return string representation of the look-and-say for the part of equal digits
   */
  private String generateNext(String digits, char prev, int curlen) {
    return "";
  }
}
