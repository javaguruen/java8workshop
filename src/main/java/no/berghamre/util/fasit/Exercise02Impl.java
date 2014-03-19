package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercises02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise02Impl implements Exercises02 {

  @Override
  public Integer getMaximumIncome(List<IncomeStatistics> incomes) {
    OptionalInt max = incomes.stream()
        .mapToInt(is -> is.averageIncome)
        .max();
    System.out.println("Max income: " + max.getAsInt() );
    return max.orElse( -1 );
  }

  @Override
  public IncomeStatistics getMaximum(List<IncomeStatistics> incomes) {
    Optional<IncomeStatistics> reduce = incomes.stream()
        .reduce((is1, is2) -> is1.averageIncome < is2.averageIncome ? is2 : is1);
    return reduce.get();
  }

  @Override
  public Integer getMinimumIncomeIn2011(List<IncomeStatistics> incomes) {
    OptionalInt min = incomes.stream()
        .filter( is -> is.year == 2011 )
        .mapToInt(is -> is.averageIncome)
        .min();
    System.out.println("Minimum income in 2011: " + min.getAsInt());
    return min.orElse( -1 );
  }

  @Override
  public Integer getMaximumIncomeForFemales(List<IncomeStatistics> incomes) {
    OptionalInt max = incomes.stream()
        .filter(is -> is.sex == Gender.female)
        .mapToInt(is -> is.averageIncome)
        .max();
    System.out.println("Maximum income for females: " + max.getAsInt());
    return max.orElse( -1 );
  }

  @Override
  public Integer getYearOfMinimumIncomeForMalesInHordaland(List<IncomeStatistics> incomes) {
    Optional<IncomeStatistics> hordaland = incomes.stream()
        .filter(Util::isMale)
        .filter( Util.isCounty("Hordaland") )
        .sorted(Util::compareByIncome)
        .findFirst();
    System.out.println("Year with minimum income for males in Hordaland: " + hordaland.get().year);
    return hordaland.get().year;
  }


  @Override
  public List<IncomeStatistics> getSumPerCountyPerYear(List<IncomeStatistics> incomes){
    Map<String, List<IncomeStatistics>> collect = incomes.stream()
        .filter(Util.isYear(2011))
        .collect(Collectors.groupingBy(is -> is.county));

    List<IncomeStatistics> summed = collect.entrySet().stream()
        .map(entry -> new IncomeStatistics(entry.getKey(), Gender.male, 2011, entry.getValue().stream().mapToInt(is -> is.averageIncome).sum()))
        .collect( Collectors.toList());
    summed.forEach( System.out::println );
    return summed;
  }
}
