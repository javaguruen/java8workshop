package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface Exercises03 {
    public class IncomeStatisticsSplitOnGender {
        public final List<IncomeStatistics> men;
        public final List<IncomeStatistics> women;

        public IncomeStatisticsSplitOnGender(List<IncomeStatistics> men, List<IncomeStatistics> women) {
            this.men = men;
            this.women = women;
        }
    }

    public Optional<IncomeStatistics> findFirstAbove400k(List<IncomeStatistics> incomeStatistics);
    public List<IncomeStatistics> allAbove(List<IncomeStatistics> incomeStatistics, int limit);
    public IncomeStatisticsSplitOnGender splitOnGender(List<IncomeStatistics> incomeStatistics);
    public List<Integer> getTopThreeYearsForRogaland( List<IncomeStatistics> incomes );
    public List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> incomes);
    public Map<String, List<IncomeStatistics>> groupedByCounty(List<IncomeStatistics> incomeStatistics);
    public LongStream arithmeticProgression(long start, long difference);
    public Stream<String> lookAndSay();
    public LongStream fibonacci();


}
