package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercises02;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
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
  public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> incomes) {
    List<Integer> rogaland = incomes.stream()
        .filter( Util.isCounty("Rogaland") )
        .sorted( Util::compareByIncome )
        .limit(3)
        .mapToInt(is -> is.year)
        .boxed()
        .collect(Collectors.<Integer>toList());
    return rogaland;
  }

  public List<Integer> getTopThreeYearsForRogaland2(List<IncomeStatistics> incomes) {
    List<Integer> rogaland = incomes.stream()
        .filter( Util.isCounty( "Rogaland"))
        .sorted( Util::compareByIncome )
        .limit(3)
        .map(is -> is.year)
        .collect(Collectors.<Integer>toList());
    System.out.println("Top 3 years for Rogaland: " + rogaland);
    return rogaland;
  }

  @Override
  public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> incomes) {
    List<String> counties = incomes.stream()
        .filter( Util::isMale)
        .filter( Util.isYear(2010) )
        .sorted(Util::compareByIncome)
        .limit(2)
        .map(is -> is.county)
        .collect(Collectors.toList());
    System.out.println("Top 2 counties for males in 2010: " + counties);
    return counties;
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
