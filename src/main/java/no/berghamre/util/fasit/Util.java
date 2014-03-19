package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This is a utility class for the provide "solution" of the exercises. Many of theese methods would
 * logically be implemented in the IncomeStatistics class.
 */
public class Util {

  public static Boolean isMale( IncomeStatistics statistics ){
    return statistics.sex == Gender.male;
  }

  public static Boolean isFemale( IncomeStatistics statistics ){
    return !isMale( statistics );
  }

  public static Predicate<IncomeStatistics> isCounty(String county){
    return (IncomeStatistics is ) -> is.county.equalsIgnoreCase( county );
  }

  public static Predicate<IncomeStatistics> isYear(int year){
    return (IncomeStatistics is ) -> is.year == year;
  }

  public static int compareByIncome(IncomeStatistics is1, IncomeStatistics is2){
    return is1.averageIncome - is2.averageIncome;
  }

//    Stream s = Stream.builder().add(1).add(2).add(3).build();
//    IntStream positiveBelow100 = new Random(7).ints(1, 100);
//    Stream s2 = Stream.iterate(3, s -> s+3);

}
