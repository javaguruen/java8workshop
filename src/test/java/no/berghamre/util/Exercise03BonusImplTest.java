package no.berghamre.util;

import no.berghamre.DataReader;
import no.berghamre.data.FamilyIncome;
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
import static org.junit.Assert.*;

public class Exercise03BonusImplTest {

    private no.berghamre.util.Exercises03Bonus exercises03Bonus;

    @Before
    public void setUp() throws Exception {
        exercises03Bonus = new Exercise03BonusImpl();
    }


    @Test
    public void testLookAndSay() throws Exception {
        List<String> tenFirstLookAndSays = exercises03Bonus.lookAndSay().map(bi -> bi.toString()).limit(9).collect(Collectors.toList());

        List<String> expected = Stream.of("1", "11", "21", "1211", "111221", "312211", "13112221", "1113213211", "31131211131221").collect(Collectors.toList());
        assertEquals(expected, tenFirstLookAndSays);
    }

    @Test
    public void testFibonacci() throws Exception {
        List<Long> tenFirstFibs = exercises03Bonus.fibonacci().limit(10).boxed().collect(Collectors.toList());


        List<Long> expected = LongStream.of(1, 1, 2, 3, 5, 8, 13, 21, 34, 55).boxed().collect(Collectors.toList());
        assertEquals(expected, tenFirstFibs);
    }
}
