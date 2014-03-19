package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.List;

public interface Exercises02 {

  Integer getMaximumIncome(List<IncomeStatistics> incomes);
  IncomeStatistics getMaximum(List<IncomeStatistics> incomes);
  Integer getMinimumIncomeIn2011(List<IncomeStatistics> incomes);
  Integer getMaximumIncomeForFemales(List<IncomeStatistics> incomes);
  Integer getYearOfMinimumIncomeForMalesInHordaland(List<IncomeStatistics> incomes);
  List<IncomeStatistics> getSumPerCountyPerYear(List<IncomeStatistics> incomes);
}
