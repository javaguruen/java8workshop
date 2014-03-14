package no.berghamre.util;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise01Impl implements Exercise01 {
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

    @Override
    public List<IncomeStatistics> getStatisticsForIncomeMoreThanSortedByIncomeDesc(List<IncomeStatistics> stats, int income) {
        return Collections.emptyList();
    }

    @Override
    public Comparator<IncomeStatistics> byGender() {
        return (o1,  o2)-> 0;
    }

    @Override
    public Comparator<IncomeStatistics> byCounty() {
        return (o1,  o2)-> 0;
    }

    @Override
    public Comparator<IncomeStatistics> byYear() {
        return (o1,  o2)-> 0;
    }

    @Override
    public Comparator<IncomeStatistics> byIncome() {
        return (o1,  o2)-> 0;
    }

    @Override
    public Comparator<IncomeStatistics> byIncomeYearCountySex() {
        return (o1,  o2)-> 0;
    }
}
