package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.List;

public interface Exercises02 {

    Integer getMaximumIncome(List<IncomeStatistics> stats);
    Integer getMinimumIncomeIn2011(List<IncomeStatistics> stats);
    Integer getMaximumIncomeForFemales(List<IncomeStatistics> stats);
    Integer getYearOfMinimumIncomeForMalesInHordaland(List<IncomeStatistics> stats);
    IncomeStatistics getMaximum(List<IncomeStatistics> stats);
}
