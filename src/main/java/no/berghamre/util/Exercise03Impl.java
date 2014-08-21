package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03Impl implements Exercises03 {

  /**
   * Return the first IncomeStatistics object having income above 400K
   */
  @Override public Optional<IncomeStatistics> findFirstAbove400k(List<IncomeStatistics> stats) {
    return Optional.empty();
  }

  /**
   * Return all Incomestatistics objects having income above the given limit
   */
  @Override public List<IncomeStatistics> allAbove(List<IncomeStatistics> stats, int limit) {
    return Collections.emptyList();
  }

  /**
   * Return the sum (male and female income) per county per year. Use IncomesStatistics class and ignore the gender-field
   */
  @Override public List<IncomeStatistics> getSumPerCountyForYear(List<IncomeStatistics> stats, Integer year) {
    return new ArrayList<>();
  }

  /**
   * Return a IncomeStatisticsSplitOnGender (Helper class).
   */
  @Override public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> stats) {
    return new IncomeStatisticsSplitOnGender(Stream.<IncomeStatistics>empty().collect(Collectors.toList()), Stream.<IncomeStatistics>empty().collect(Collectors.toList()));
  }

  /**
   * Return a list of top three (in descending order) years of income (regardless of sex) in Rogaland
   */
  @Override public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> stats) {
    return null;
  }

  /**
   * Get the third and fourth county (based on income) for males in 2010
   */
  @Override public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> stats) {
    return null;
  }

  /**
   * Return lists of IncomeStatistics grouped by county.
   */
  @Override public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> stats) {
    return Collections.emptyMap();
  }

  /**
   * a_n = a_1 + (n-1)d or a_n = a_n-1 + d
   *
   * Hint: http://en.wikipedia.org/wiki/Arithmetic_progression
   */
  @Override public LongStream arithmeticProgression(long start, long difference) {
    return LongStream.empty();
  }

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
