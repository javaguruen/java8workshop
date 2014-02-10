package no.berghamre.util;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.Collections;
import java.util.List;

public class IncomeListUtilImpl implements IncomeListUtil{
    @Override
    public List<IncomeStatistics> decodeLinesUsingForEach(List<String> lines) {
        return Collections.emptyList(); 
    }

    @Override
    public List<IncomeStatistics> getStatisticsForGender(List<IncomeStatistics> stats, Gender gender) {
        return Collections.emptyList(); 
    }

    @Override
    public List<IncomeStatistics> getStatisticsForYearsBefore(List<IncomeStatistics> stats, int year) {
        return Collections.emptyList(); 
    }

    @Override
    public List<IncomeStatistics> getStatisticsForYearsAfter(List<IncomeStatistics> stats, int year) {
        return Collections.emptyList();  
    }

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeLessThan(List<IncomeStatistics> stats, int income) {
        return Collections.emptyList(); 
    }

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeMoreThan(List<IncomeStatistics> stats, int income) {
        return Collections.emptyList();  
    }
}
