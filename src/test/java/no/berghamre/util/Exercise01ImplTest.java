package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class Exercise01ImplTest {

    private Exercise01 ilu;
    private List<IncomeStatistics> statistics;

    @Before
    public void setUp() throws Exception {
        ilu = new Exercise01Impl();
        statistics = DataReader.decodeLinesUsingForEach();
    }

    @Test
    public void testDecodeLinesUsingForEach() throws Exception {
        Assert.assertThat("Statistics contains 38 elements", statistics.size(), is(570));
        Assert.assertThat("thirtieth element is from Akershus", statistics.get(30).county, is("Akershus"));
        Assert.assertThat("Gender of first element is male", statistics.get(0).sex, is(Gender.male));
        Assert.assertThat("Last element is from Finnmark", statistics.get(569).county, is("Finnmark"));
        Assert.assertThat("Gender of last element is female", statistics.get(569).sex, is(Gender.female));
        Assert.assertThat("Income for Vestfold, female, 1997 is 132400", statistics.get(195).averageIncome, is(132400));
        Assert.assertThat("Income for Vestfold, female, 2011 is 281900", statistics.get(209).averageIncome, is(281900));
    }

    @Test
    public void testGetStatisticsForGender() throws Exception {
        ArrayList<IncomeStatistics> copy = new ArrayList<>(statistics);
        List<IncomeStatistics> male = ilu.getStatisticsForGender(copy, Gender.male);

        Assert.assertThat("male contains 285 elements", male.size(), is(285));
        male.forEach((IncomeStatistics is) -> {
            if (is.sex == Gender.female) {
                throw new RuntimeException("Gender was female");
            }
        });
    }

    @Test
    public void testGetStatisticsForYearsBefore() throws Exception {
        ArrayList<IncomeStatistics> copy = new ArrayList<>(statistics);
        List<IncomeStatistics> before = ilu.getStatisticsForYearsBefore(copy, 2003);

        Assert.assertThat("before contains 38 elements", before.size(), is(228));
        before.forEach((IncomeStatistics is) -> {
            if (is.year >= 2003) {
                throw new RuntimeException("Year was not less than 2003");
            }
        });
    }

    @Test
    public void testGetStatisticsForYearsAfter() throws Exception {
        ArrayList<IncomeStatistics> copy = new ArrayList<>(statistics);
        List<IncomeStatistics> after = ilu.getStatisticsForYearsAfter(copy, 2004);

        Assert.assertThat("after contains 266 elements", after.size(), is(266));
        after.forEach((IncomeStatistics is) -> {
            if (is.year <= 2004) {
                throw new RuntimeException("Year was not greater than 2004");
            }
        });
    }

    @Test
    public void testGetStatisticsForIncomeLessThan() throws Exception {
        ArrayList<IncomeStatistics> copy = new ArrayList<>(statistics);
        List<IncomeStatistics> less = ilu.getStatisticsForIncomeLessThan(copy, 200000);

        Assert.assertThat("less contains 131 elements", less.size(), is(131));
        less.forEach((IncomeStatistics is) -> {
            if (is.averageIncome >= 200000) {
                throw new RuntimeException("averageIncome was not less than 200000");
            }
        });
    }

    @Test
    public void testGetStatisticsForIncomeMoreThan() throws Exception {
        ArrayList<IncomeStatistics> copy = new ArrayList<>(statistics);
        List<IncomeStatistics> more = ilu.getStatisticsForIncomeMoreThan(copy, 200000);

        Assert.assertThat("more contains 439 elements", more.size(), is(439));
        more.forEach((IncomeStatistics is) -> {
            if (is.averageIncome <= 200000) {
                throw new RuntimeException("averageIncome was not more than 200000");
            }
        });
    }

    @Test
    public void testCountyComparator() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Oslo", Gender.female, 2000, 300000);
        IncomeStatistics is2 = new IncomeStatistics("Oslo", Gender.male, 2000, 350000);
        IncomeStatistics is3 = new IncomeStatistics("Hordaland", Gender.male, 2000, 380000);

        Assert.assertThat("Oslo equals Oslo", ilu.byCounty().compare(is1, is2), is(0));
        Assert.assertTrue("Oslo is after Hordaland", ilu.byCounty().compare(is1, is3) > 0);
        Assert.assertTrue("Hordaland is before Oslo", ilu.byCounty().compare(is3, is2) < 0);

    }

    @Test
    public void testGenderComparator() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Oslo", Gender.female, 2000, 300000);
        IncomeStatistics is2 = new IncomeStatistics("Oslo", Gender.male, 2000, 350000);
        IncomeStatistics is3 = new IncomeStatistics("Hordaland", Gender.male, 2000, 380000);

        Assert.assertThat("male equals male", ilu.byGender().compare(is2, is3), is(0));
        Assert.assertTrue("female is before male", ilu.byGender().compare(is1, is3) < 0);
        Assert.assertTrue("male is after female", ilu.byGender().compare(is2, is1) > 0);

    }

    @Test
    public void testIncomeComparator() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Oslo", Gender.female, 2000, 300000);
        IncomeStatistics is2 = new IncomeStatistics("Oslo", Gender.male, 2000, 350000);
        IncomeStatistics is3 = new IncomeStatistics("Hordaland", Gender.male, 1998, 350000);

        Assert.assertThat("350000 equals 350000", ilu.byIncome().compare(is3, is2), is(0));
        Assert.assertTrue("300000 is before 350000", ilu.byIncome().compare(is1, is3) < 0);
        Assert.assertTrue("350000 is after 300000", ilu.byIncome().compare(is2, is1) > 0);

    }

    @Test
    public void testYearComparator() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Oslo", Gender.female, 2000, 300000);
        IncomeStatistics is2 = new IncomeStatistics("Oslo", Gender.male, 2000, 350000);
        IncomeStatistics is3 = new IncomeStatistics("Hordaland", Gender.male, 2001, 380000);

        Assert.assertThat("2000 equals 2000", ilu.byYear().compare(is1, is2), is(0));
        Assert.assertTrue("2000 is before 2001", ilu.byYear().compare(is1, is3) < 0);
        Assert.assertTrue("2001 is after 2000", ilu.byYear().compare(is3, is2) > 0);

    }

    @Test
    public void testbyIncomeYearCountySexComparator() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Hordaland", Gender.female, 2000, 350000);
        IncomeStatistics is2 = new IncomeStatistics("Oslo", Gender.male, 2001, 300000);
        IncomeStatistics is3 = new IncomeStatistics("Oslo", Gender.male, 2000, 380000);
        IncomeStatistics is4 = new IncomeStatistics("Hordaland", Gender.female, 2001, 380000);
        IncomeStatistics is5 = new IncomeStatistics("Hordaland", Gender.male, 2001, 380000);
        IncomeStatistics is6 = new IncomeStatistics("Oslo", Gender.female, 2001, 380000);
        IncomeStatistics is7 = new IncomeStatistics("Hordaland", Gender.male, 2001, 380000);
        IncomeStatistics is8 = new IncomeStatistics("Hordaland", Gender.female, 2001, 380000);
        IncomeStatistics is9 = new IncomeStatistics("Hordaland", Gender.female, 2001, 380000);

        Assert.assertTrue("350000 after 300000", ilu.byIncomeYearCountySex().compare(is1, is2) > 0);
        Assert.assertTrue("2000 before 2001", ilu.byIncomeYearCountySex().compare(is3, is4) < 0);
        Assert.assertTrue("Hordaland before Oslo", ilu.byIncomeYearCountySex().compare(is5, is6) < 0);
        Assert.assertTrue("male after female", ilu.byIncomeYearCountySex().compare(is7, is8) > 0);
        Assert.assertThat("All the same returns 0", ilu.byIncomeYearCountySex().compare(is8, is9), is(0));
    }

    @Test
    public void testGetStatisticsForIncomeMoreThanSortedByIncomeDesc() throws Exception {
        IncomeStatistics is1 = new IncomeStatistics("Østfold", Gender.male, 1999, 258100);
        IncomeStatistics is2 = new IncomeStatistics("Østfold", Gender.female, 2000, 162400);
        IncomeStatistics is3 = new IncomeStatistics("Akershus", Gender.male, 2001, 369400);
        IncomeStatistics is4 = new IncomeStatistics("Akershus", Gender.female, 2002, 232100);
        IncomeStatistics is5 = new IncomeStatistics("Oslo", Gender.male, 2003, 409200);
        IncomeStatistics is6 = new IncomeStatistics("Oslo", Gender.female, 2004, 264200);
        IncomeStatistics is7 = new IncomeStatistics("Hedmark", Gender.male, 2005, 308900);
        IncomeStatistics is8 = new IncomeStatistics("Hedmark", Gender.female, 2006, 208400);

        List<IncomeStatistics> is = Arrays.asList(is1, is2, is3, is4, is5, is6, is7, is8);
        List<IncomeStatistics> expected = Arrays.asList(is5, is3, is7, is6, is1);

        List<IncomeStatistics> actual = ilu.getStatisticsForIncomeMoreThanSortedByIncomeDesc(is, 250000);

        Assert.assertEquals(expected, actual);

    }
}
