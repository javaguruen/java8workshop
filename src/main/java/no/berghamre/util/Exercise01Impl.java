package no.berghamre.util;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise01Impl implements Exercises01 {

  /**
   * Return a comparator that compares by income
   */
  @Override
  public Comparator<IncomeStatistics> byIncome() {
    return (o1, o2) -> o1.averageIncome - o2.averageIncome;
  }

  /**
   * Return a comparator that compares by gender
   */
  @Override
  public Comparator<IncomeStatistics> byGender() {
    return (o1, o2) -> 0;
  }

  /**
   * Return a comparator that compares by county
   */
  @Override
  public Comparator<IncomeStatistics> byCounty() {
    return (o1, o2) -> 0;
  }

  /**
   * Return a comparator that compares by year
   */
  @Override
  public Comparator<IncomeStatistics> byYear() {
    return (o1, o2) -> 0;
  }

  /**
   * Return a comparator that compares by income then year then county then sex
   */
  @Override
  public Comparator<IncomeStatistics> byIncomeYearCountySex() {
    return (o1, o2) -> 0;
  }

  /**
   * Create and return a new list containing IncomeStatistics only for the given <code>gender</code>
   */
  @Override
  public List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender) {
    return Collections.emptyList();
  }

  /**
   * Create and return a new list containing IncomeStatistics for the years before <code>year</code>
   */
  @Override
  public List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year) {
    return Collections.emptyList();
  }

  /**
   * Create and return a new list containing IncomeStatistics for the years after <code>year</code>
   */
  @Override
  public List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year) {
    return Collections.emptyList();
  }

  /**
   * Create and return a new list containing IncomeStatistics with income less than the given <code>income</code>
   */
  @Override
  public List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income) {
    return Collections.emptyList();
  }

  /**
   * Create and return a new list containing IncomeStatistics with more income than the given <code>income</code>
   */
  @Override
  public List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income) {
    return Collections.emptyList();
  }

  /**
   * Create and return a new list containing IncomeStatistics with more income than the given <code>income</code>.
   * The list should be sorted by income in a descending order.
   */
  @Override
  public List<IncomeStatistics> getStatisticsForIncomeMoreThanSortedByIncomeDesc(List<IncomeStatistics> stats, int income) {
    return Collections.emptyList();
  }
}
