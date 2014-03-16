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

  List<Integer> getTopThreeYearsForRogaland( List<IncomeStatistics> incomes );
  List<String> getNr3And4CountiesForMalesIn2010(List<IncomeStatistics> incomes);
  //Sortert liste på fylker in 2010 sammenlagt på kjønn
  //Finn første med inntekt over 400000
  //finn alle som har over en grense (vha findAll)


}
