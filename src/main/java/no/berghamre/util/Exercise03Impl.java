package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.fasit.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03Impl implements Exercises03 {

  @Override
  public Optional<IncomeStatistics> findFirstAbove400k(List<IncomeStatistics> stats) {
    return Optional.empty();
  }

  @Override
  public List<IncomeStatistics> allAbove(List<IncomeStatistics> stats, int limit) {
    return Collections.emptyList();
  }

  @Override
  public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> stats) {
    return new IncomeStatisticsSplitOnGender(Stream.<IncomeStatistics>empty().collect(Collectors.toList()), Stream.<IncomeStatistics>empty().collect(Collectors.toList()));
  }

  @Override
  public List<IncomeStatistics> getSumPerCountyPerYear(List<IncomeStatistics> stats) {
    return new ArrayList<>();
  }

  @Override
  public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> stats) {
    return Collections.EMPTY_MAP;
  }


  @Override
  public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> stats) {
    return null;
  }

  @Override
  public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> stats) {
    return null;
  }

  /**
   * a_n = a_1 + (n-1)d or a_n = a_n-1 + d
   *
   * Hint: http://en.wikipedia.org/wiki/Arithmetic_progression
   */
  @Override
  public LongStream arithmeticProgression(long start, long difference) {
    return LongStream.empty();
  }

  /**
   * Hint: always start with "1"  next is "11", "21", "1211" ...
   * see: http://en.wikipedia.org/wiki/Look-and-say_sequence
   */
  @Override
  public Stream<String> lookAndSay() {
    return Stream.<String>empty();
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

  @Override
  public LongStream fibonacci() {
    return no.berghamre.util.fasit.FibonacciGenerator.fibonacci();
  }
}
