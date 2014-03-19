package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercises03;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03Impl implements Exercises03 {

  @Override
  public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> incomeStatistics) {
    Map<Boolean, List<IncomeStatistics>> split = incomeStatistics.stream().collect(Collectors.partitioningBy(is -> Gender.female == is.sex));

    return new IncomeStatisticsSplitOnGender(split.get(true), split.get(false));
  }

  @Override
  public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> incomeStatistics) {
    Map<String, List<IncomeStatistics>> grouped = incomeStatistics.stream().collect(Collectors.groupingBy(is -> is.county));
    return grouped;
  }

  @Override
  public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> incomes) {
    Comparator<IncomeStatistics> byIncome = Util::compareByIncome;
    List<Integer> rogaland = incomes.stream()
        .filter(Util.isCounty("Rogaland"))
        .sorted(byIncome.reversed())
        .limit(3)
        .mapToInt(is -> is.year)
        .boxed()
        .collect(Collectors.<Integer>toList());
    return rogaland;
  }

  public List<Integer> getTopThreeYearsForRogaland2(List<IncomeStatistics> incomes) {
    Comparator<IncomeStatistics> byIncome = Util::compareByIncome;
    List<Integer> rogaland = incomes.stream()
        .filter(Util.isCounty("Rogaland"))
        .sorted(byIncome.reversed())
        .limit(3)
        .map(is -> is.year)
        .collect(Collectors.<Integer>toList());
    System.out.println("Top 3 years for Rogaland: " + rogaland);
    return rogaland;
  }

  @Override
  public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> incomes) {
    List<String> counties = incomes.stream()
        .filter(Util::isMale)
        .filter(Util.isYear(2010))
        .sorted(((Comparator<IncomeStatistics>) Util::compareByIncome).reversed())
        .skip(2)
        .limit(2)
        .map(is -> is.county)
        .collect(Collectors.toList());
    System.out.println("Top 2 counties for males in 2010: " + counties);
    return counties;
  }


  @Override
  public LongStream arithmeticProgression(long start, long difference) {
    return LongStream.iterate(start, s -> s + difference);
  }

  @Override
  public Stream<String> lookAndSay() {
    return Stream.<String>iterate("1", s -> {
      return generateNext(s.substring(1), s.charAt(0), 1);
    });
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

  @Override
  public LongStream fibonacci() {
    return FibonacciGenerator.fibonacci();
  }
}
