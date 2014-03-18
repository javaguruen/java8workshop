package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.IncomeStatistics;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
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
    public void testSplitOnGender() throws Exception {
        Exercises03.IncomeStatisticsSplitOnGender onGender = exercises03.splitOnGender(statistics);
        List<IncomeStatistics> women = onGender.women;
        List<IncomeStatistics> men = onGender.men;
        assertThat(women.size(), is(285));
        assertThat(men.size(), is(285));

    }

    @Test
    public void testGroupedByCounty() throws Exception {
        Map<String,List<IncomeStatistics>> groupedByCounty = exercises03.groupedByCounty(statistics);

        int size = groupedByCounty.size();

        assertThat(size, is(19));

        groupedByCounty.entrySet().forEach(e ->{
            final String key = e.getKey();
            e.getValue().forEach(is -> {
                if(!key.equals(is.county)){
                    throw new RuntimeException("county was not the same as key");
                }
            });
        });
    }

    @Test
    public void testArithmeticProgression() throws Exception {
        List<? super Long> by6StartWith7 =  exercises03.arithmeticProgression(7, 6).limit(7).boxed().collect(Collectors.toList());

        List<? super Long> expected = LongStream.of(7, 13, 19, 25, 31, 37, 43).boxed().collect(Collectors.toList());

        assertEquals(expected, by6StartWith7);
    }

    @Test
    public void testLookAndSay() throws Exception {
        List<? super String> tenFirstLookAndSays = exercises03.lookAndSay().map(bi -> bi.toString()).limit(9).collect(Collectors.toList());

        List<? super String> expected = Stream.of("1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211", "31131211131221").collect(Collectors.toList());
        assertEquals(expected, tenFirstLookAndSays);
    }

    @Test
    public void testFibonacci() throws Exception {
        List<? super Long> tenFirstFibs = (List<? super Long>) FibonacciGenerator.fibonacci().limit(10).boxed().collect(Collectors.toList());


        List<? super Long> expected = (List<? super Long>) LongStream.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55).boxed().collect(Collectors.toList());
        assertEquals(expected, tenFirstFibs);
    }
}
