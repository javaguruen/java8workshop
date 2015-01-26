package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Exercise02ImplTest {

  private List<IncomeStatistics> statistics;
  private Exercises02 exercises02;

  @Before
  public void setUp() throws Exception {
    statistics = DataReader.decodeLinesUsingForEach();
    exercises02 = new Exercise02Impl();
  }


  /**
   * Maximum avearge income
   */
  @Test
  public void testGetMaximumIncome() throws Exception {
    Integer maximumIncome = exercises02.getMaximumIncome(statistics);
    assertThat(maximumIncome, is(530600));
  }

  @Test
  public void testGetMinimumIncomeIn2011() throws Exception {
    Integer minimumIncome = exercises02.getMinimumIncomeIn2011(statistics);
    assertThat(minimumIncome, is(270700));
  }

  @Test
  public void testGetMaximumIncomeForFemales() throws Exception {
    Integer maximumIncomeForFemales = exercises02.getMaximumIncomeForFemales(statistics);
    assertThat(maximumIncomeForFemales, is(345100));
  }

  @Test
  public void testGetYearOfMinimumIncomeForMalesInHordaland() throws Exception {
    Integer minYear = exercises02.getYearOfMinimumIncomeForMalesInHordaland(statistics);
    assertThat(minYear, is(1997));
  }

  @Test
  public void testGetMaximum() throws Exception {
    IncomeStatistics maximum = exercises02.getMaximum(statistics);
    assertThat(maximum.year, is(2011));
    assertThat(maximum.sex, is(Gender.male));
    assertThat(maximum.county, is("Rogaland"));
    assertThat(maximum.averageIncome, is(530600));
  }
}
