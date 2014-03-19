package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03Impl implements Exercises03 {
    @Override
    public Optional<IncomeStatistics> findFirstAbove400k(List<IncomeStatistics> incomeStatistics) {
        return Optional.empty();
    }

    @Override
    public List<IncomeStatistics> allAbove(List<IncomeStatistics> incomeStatistics, int limit) {
        return Collections.emptyList();
    }

    @Override
    public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> incomeStatistics) {
        return new IncomeStatisticsSplitOnGender(Stream.<IncomeStatistics>empty().collect(Collectors.toList()), Stream.<IncomeStatistics>empty().collect(Collectors.toList()));
    }

    @Override
    public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> incomeStatistics) {
        return Collections.EMPTY_MAP;
    }


    @Override
    public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> incomes) {
    return null;
  }

    @Override
    public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> incomes) {
    return null;
  }

  /**
   * Hint: http://en.wikipedia.org/wiki/Arithmetic_progression
   * @param start
   * @param difference
   * @return
   */
    @Override
    public LongStream arithmeticProgression(long start, long difference) {
        return LongStream.empty();
    }

  /**
   * Hint: always start with "1" see: http://en.wikipedia.org/wiki/Look-and-say_sequence
   * @return
   */
    @Override
    public Stream<String> lookAndSay() {
        return Stream.<String>empty();
    }

  /**
   * Helper for lookAndSay. Tip: make this recursive
   * @param digits  current digits
   * @param prev  previous digit
   * @param curlen current length of equal digits
   * @return string representation of the look-and-say for the part of equal digits
   */
    private String  generateNext(String digits , char prev, int curlen){
    return "";
  }

    @Override
    public LongStream fibonacci() {
        return LongStream.empty();
    }

}
