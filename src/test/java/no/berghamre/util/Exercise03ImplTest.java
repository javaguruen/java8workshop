package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Exercise03ImplTest {

  private List<IncomeStatistics> statistics;
  private Exercises03 exercises03;

  @Before
  public void setUp() throws Exception {
    statistics = DataReader.decodeLinesUsingForEach();
    exercises03 = new Exercise03Impl();
  }

  @Test
  public void testFindFirstAbove400k() throws Exception {
    Optional<IncomeStatistics> is = exercises03.findFirstAbove400k(statistics);

    assertThat(is.isPresent(), is(true));
    IncomeStatistics firstAbove400k = is.get();

    assertThat("county is Østfold", firstAbove400k.county, is("Østfold"));
    assertThat("gender is male", firstAbove400k.sex, is(Gender.male));
    assertThat("year is 2011", firstAbove400k.year, is(2011));
    assertThat("income is 403100", firstAbove400k.averageIncome, is(403100));
  }

  @Test
  public void testAllAbove() throws Exception {
    List<IncomeStatistics> is = exercises03.allAbove(statistics, 375000);
    assertThat(is.size(), is(88));

    is.forEach(i -> {
      if (!(i.averageIncome > 375000)) {
        throw new RuntimeException("income was not above limit");
      }
    });
  }

  @Test
  public void testGetSumPerCountyPerYear() {
    List<IncomeStatistics> sumPerCountyPerYear = exercises03.getSumPerCountyPerYear(statistics);
    assertThat("find something to assert on", sumPerCountyPerYear.size(), is(19));
  }

  @Test
  public void testSplitOnGender() throws Exception {
    Exercises03.IncomeStatisticsSplitOnGender onGender = exercises03.splitOnGender(statistics);
    List<IncomeStatistics> women = onGender.women;
    List<IncomeStatistics> men = onGender.men;
    assertThat(women.size(), is(285));
    assertThat(men.size(), is(285));
  }

  @Test
  public void testGetTopThreeYearsForRogaland() {
    List<Integer> minYear = exercises03.getTopThreeYearsForRogaland(statistics);
    assertThat(minYear, is(Arrays.asList(2011, 2010, 2008)));
  }

  @Test
  public void testGetNr3And4CountiesForMalesIn2010() {
    List<String> minYear = exercises03.getNr3And4CountiesForMalesIn2010(statistics);
    assertThat(minYear, is(Arrays.asList("Oslo", "Hordaland")));
  }


  @Test
  public void testGroupedByCounty() throws Exception {
    Map<String, List<IncomeStatistics>> groupedByCounty = exercises03.groupedByCounty(statistics);

    int size = groupedByCounty.size();

    assertThat(size, is(19));

    groupedByCounty.entrySet().forEach(e -> {
      final String key = e.getKey();
      e.getValue().forEach(is -> {
        if (!key.equals(is.county)) {
          throw new RuntimeException("county was not the same as key");
        }
      });
    });
  }

  @Test
  public void testArithmeticProgression() throws Exception {
    List<Long> by6StartWith7 = exercises03.arithmeticProgression(7, 6).limit(7).boxed().collect(Collectors.toList());

    List<Long> expected = LongStream.of(7, 13, 19, 25, 31, 37, 43).boxed().collect(Collectors.toList());

    assertEquals(expected, by6StartWith7);
  }

  @Test
  public void testLookAndSay() throws Exception {
    List<String> tenFirstLookAndSays = exercises03.lookAndSay().map(bi -> bi.toString()).limit(9).collect(Collectors.toList());

    List<String> expected = Stream.of("1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211", "31131211131221").collect(Collectors.toList());
    assertEquals(expected, tenFirstLookAndSays);
  }

  @Test
  public void testFibonacci() throws Exception {
    List<Long> tenFirstFibs = exercises03.fibonacci().limit(10).boxed().collect(Collectors.toList());


    List<Long> expected = LongStream.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55).boxed().collect(Collectors.toList());
    assertEquals(expected, tenFirstFibs);
  }
}
