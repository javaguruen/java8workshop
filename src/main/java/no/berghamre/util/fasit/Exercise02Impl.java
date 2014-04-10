package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercises02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise02Impl implements Exercises02 {

  @Override
  public Integer getMaximumIncome(List<IncomeStatistics> stats) {
    OptionalInt max = stats.stream()
        .mapToInt(is -> is.averageIncome)
        .max();
    System.out.println("Max income: " + max.getAsInt() );
    return max.orElse( -1 );
  }

  @Override
  public IncomeStatistics getMaximum(List<IncomeStatistics> stats) {
    Optional<IncomeStatistics> reduce = stats.stream()
        .reduce((is1, is2) -> is1.averageIncome < is2.averageIncome ? is2 : is1);
    return reduce.get();
  }

  @Override
  public Integer getMinimumIncomeIn2011(List<IncomeStatistics> stats) {
    OptionalInt min = stats.stream()
        .filter( is -> is.year == 2011 )
        .mapToInt(is -> is.averageIncome)
        .min();
    System.out.println("Minimum income in 2011: " + min.getAsInt());
    return min.orElse( -1 );
  }

  @Override
  public Integer getMaximumIncomeForFemales(List<IncomeStatistics> stats) {
    OptionalInt max = stats.stream()
        .filter(is -> is.sex == Gender.female)
        .mapToInt(is -> is.averageIncome)
        .max();
    System.out.println("Maximum income for females: " + max.getAsInt());
    return max.orElse( -1 );
  }

  @Override
  public Integer getYearOfMinimumIncomeForMalesInHordaland(List<IncomeStatistics> stats) {
    Optional<IncomeStatistics> hordaland = stats.stream()
        .filter(Util::isMale)
        .filter( Util.isCounty("Hordaland") )
        .sorted(Util::compareByIncome)
        .findFirst();
    System.out.println("Year with minimum income for males in Hordaland: " + hordaland.get().year);
    return hordaland.get().year;
  }
}
