package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.IncomeStatistics;
import no.berghamre.util.fasit.*;
import no.berghamre.util.fasit.Exercise02Impl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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
   * @throws Exception
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
    assertThat( maximumIncomeForFemales, is (345100));
  }

  @Test
  public void testGetYearOfMinimumIncomeForMalesInHordaland() throws Exception {
    Integer minYear = exercises02.getYearOfMinimumIncomeForMalesInHordaland(statistics);
    assertThat(minYear, is(1997));
  }

  @Test
  public void testGetTopThreeYearsForRogaland() {
    List<Integer> minYear = exercises02.getTopThreeYearsForRogaland(statistics);
    assertThat(minYear, is(Arrays.asList( 2011, 2010, 2008)));
  }

  @Test
  public void testGetNr3And4CountiesForMalesIn2010() {
    List<String> minYear = exercises02.getNr3And4CountiesForMalesIn2010(statistics);
    assertThat(minYear, is( Arrays.asList("Oslo", "Hordaland")));
  }

  @Test
  public void testGetSumPerCountyPerYear() {
    List<IncomeStatistics> sumPerCountyPerYear = exercises02.getSumPerCountyPerYear(statistics);
    assertThat("find something to assert on", sumPerCountyPerYear.size(), is(19));
  }
}
