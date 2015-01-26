package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercises01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise01Impl implements Exercises01 {

  @Override
  public Comparator<IncomeStatistics> byIncome() {
    return Util::compareByIncome;
  }

  @Override
  public Comparator<IncomeStatistics> byGender() {
    return (o1, o2) -> o1.sex.compareTo(o2.sex);
  }

  @Override
  public Comparator<IncomeStatistics> byCounty() {
    return Comparator.comparing((IncomeStatistics is) -> is.county, String.CASE_INSENSITIVE_ORDER);
  }

  @Override
  public Comparator<IncomeStatistics> byYear() {
    return (o1, o2) -> o1.year - o2.year;
  }

  @Override
  public Comparator<IncomeStatistics> byIncomeYearCountySex() {
    return byIncome().thenComparing(byYear()).thenComparing(byCounty()).thenComparing(byGender());
  }

  @Override
  public List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender) {
    ArrayList<IncomeStatistics> retval = new ArrayList<>(stats);
    retval.removeIf(is -> is.sex != gender);
    return retval;
  }

  @Override
  public List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year) {
    ArrayList<IncomeStatistics> retval = new ArrayList<>(stats);
    retval.removeIf(is -> is.year >= year);
    return retval;
  }

  @Override
  public List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year) {
    ArrayList<IncomeStatistics> retval = new ArrayList<>(stats);
    retval.removeIf(is -> is.year <= year);
    return retval;
  }

  @Override
  public List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income) {
    ArrayList<IncomeStatistics> retval = new ArrayList<>(stats);
    retval.removeIf(iS -> iS.averageIncome >= income);
    return retval;
  }

  @Override
  public List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income) {
    ArrayList<IncomeStatistics> retval = new ArrayList<>(stats);
    retval.removeIf(is -> is.averageIncome <= income);
    return retval;
  }

  @Override
  public List<IncomeStatistics> getStatisticsForIncomeMoreThanSortedByIncomeDesc(List<IncomeStatistics> stats, int income) {
    List<IncomeStatistics> retval = getStatisticsForIncomeMoreThan(stats, income);
    retval.sort(byIncome().reversed());
    return retval;
  }
}
