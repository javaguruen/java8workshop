package no.berghamre.data;

public class FamilyIncome {

  public final String county;
  public final int year;
  public final int totalAverageIncome;

  public FamilyIncome(String county, int year, int totalAverageIncome) {
    this.county = county;
    this.year = year;
    this.totalAverageIncome = totalAverageIncome;
  }
}
