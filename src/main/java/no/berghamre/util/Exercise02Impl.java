package no.berghamre.util;

import no.berghamre.data.IncomeStatistics;

import java.util.List;

public class Exercise02Impl implements Exercises02 {

  @Override
  public Integer getMaximumIncome(List<IncomeStatistics> incomes) {
    return -1;
  }

  @Override
  public Integer getMinimumIncomeIn2011(List<IncomeStatistics> incomes) {
    return -1;
  }

  @Override
  public Integer getMaximumIncomeForFemales(List<IncomeStatistics> incomes) {
    return -1;
  }

  @Override
  public Integer getYearOfMinimumIncomeForMalesInHordaland(List<IncomeStatistics> incomes) {
    return -1;
  }

  @Override
  public List<Integer> getTopThreeYearsForRogaland(List<IncomeStatistics> incomes) {
    return null;
  }

  @Override
  public List<String> getTopTwoCountiesForMalesIn2010(List<IncomeStatistics> incomes) {
    return null;
  }
}