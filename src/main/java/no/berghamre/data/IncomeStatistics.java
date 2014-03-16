package no.berghamre.data;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatistics {

  public final String county;
  public final Gender sex;
  public final int year;
  public final int averageIncome;

  public IncomeStatistics(String county, Gender sex, int year, int averageIncome) {
    this.county = county;
    this.sex = sex;
    this.year = year;
    this.averageIncome = averageIncome;
  }

  @Override
  public String toString() {
    return "IncomeStatistics{" +
        "county='" + county + '\'' +
        ", sex=" + sex +
        ", year=" + year +
        ", averageIncome=" + averageIncome +
        '}';
  }
}
