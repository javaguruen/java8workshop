package no.berghamre.util;

import no.berghamre.data.FamilyIncome;
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
  @Override public List<FamilyIncome> getSumPerCountyForYear(List<IncomeStatistics> stats, Integer year) {
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

}
