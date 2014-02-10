package no.berghamre.util;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.List;

public interface IncomeListUtil {
    List<IncomeStatistics> decodeLinesUsingForEach(List<String> lines);
    List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender);
    List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year);
    List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year);
    List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income);
    List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income);
}
