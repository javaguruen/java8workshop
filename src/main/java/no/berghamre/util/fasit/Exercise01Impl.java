package no.berghamre.util.fasit;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.Exercise01;

import java.util.Comparator;
import java.util.List;

public class Exercise01Impl implements Exercise01 {

    @Override
    public List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender) {
        stats.removeIf(is -> is.sex != gender);
        return stats;
    }

    @Override
    public List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year) {
        stats.removeIf(is -> is.year >= year);
        return stats;
    }

    @Override
    public List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year) {
        stats.removeIf(is -> is.year <= year);
        return stats;
    }

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income) {
        stats.removeIf(iS -> iS.averageIncome >= income);
        return stats;
    }

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income) {
        stats.removeIf(is -> is.averageIncome <= income);
        return stats;
    }

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeMoreThanSortedByIncomeDesc(List<IncomeStatistics> stats, int income) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Comparator<IncomeStatistics> byGender() {
        return (o1, o2) -> o1.sex.compareTo(o2.sex);
    }

    @Override
    public Comparator<IncomeStatistics> byCounty() {
        return Comparator.comparing(Util::getCounty, String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public Comparator<IncomeStatistics> byYear() {
        return (o1, o2) -> o1.year - o2.year;
    }

    @Override
    public Comparator<IncomeStatistics> byIncome() {
        return Util::compareByIncome;
    }

    @Override
    public Comparator<IncomeStatistics> byIncomeYearCountySex() {
        return byIncome().thenComparing(byYear()).thenComparing(byCounty()).thenComparing(byGender());
    }
}
