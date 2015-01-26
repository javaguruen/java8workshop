package no.berghamre.util.fasit;

import no.berghamre.util.Exercises03Bonus;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03BonusImpl implements Exercises03Bonus {

  @Override
  public Stream<String> lookAndSay() {
    return Stream.iterate("1", s -> {
      return generateNext(s.substring(1), s.charAt(0), 1);
    });
  }

  @Override
  public LongStream fibonacci() {
    return FibonacciGenerator.fibonacci();
  }

  private String generateNext(String digits, char prev, int curlen) {
    String next;
    if ("".equals(digits)) {
      next = Integer.toString(curlen) + prev;
    }
    else if (prev == digits.charAt(0)) {
      next = generateNext(digits.substring(1), prev, (curlen + 1));
    }
    else {
      next = Integer.toString(curlen) + prev + generateNext(digits.substring(1), digits.charAt(0), 1);
    }
    return next;
  }
}
