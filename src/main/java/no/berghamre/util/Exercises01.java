package no.berghamre.util;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.Comparator;
import java.util.List;

public interface Exercises01 {
    Comparator<IncomeStatistics> byIncome();
    Comparator<IncomeStatistics> byGender(); // female before male
    Comparator<IncomeStatistics> byCounty();
    Comparator<IncomeStatistics> byYear();
    Comparator<IncomeStatistics> byIncomeYearCountySex();
    List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender);
    List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year);
    List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year);
    List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income);
    List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income);
    List<IncomeStatistics> getStatisticsForIncomeMoreThanSortedByIncomeDesc(List<IncomeStatistics> stats, int income);

}
