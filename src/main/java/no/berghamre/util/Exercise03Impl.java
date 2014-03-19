package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03Impl implements Exercises03 {
    @Override
    public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> incomeStatistics) {
        return new IncomeStatisticsSplitOnGender(Stream.<IncomeStatistics>empty().collect(Collectors.toList()), Stream.<IncomeStatistics>empty().collect(Collectors.toList()));
    }

    @Override
    public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> incomeStatistics) {
        return Collections.EMPTY_MAP;
    }

    @Override
    public LongStream arithmeticProgression(long start, long difference) {
        return LongStream.empty();
    }

    @Override
    public Stream<String> lookAndSay() {
        return Stream.<String>empty();
    }

    private String  generateNext(String digits , char prev, int curlen){
        return "";
    }

    @Override
    public LongStream fibonacci() {
        return LongStream.empty();
    }

}
