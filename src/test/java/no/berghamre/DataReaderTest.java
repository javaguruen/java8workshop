package no.berghamre;

import no.berghamre.data.Gender;
import no.berghamre.data.IncomeStatistics;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class DataReaderTest {

  @Test
  public void readFromFile() {
    final List<String> data = DataReader.readData();
    Assert.assertThat("Should be 39 lines", data.size(), is(39));
  }

  @Test
  public void readFromFileStream() throws IOException {
    final List<IncomeStatistics> data = DataReader.read();
    Assert.assertThat("Should be 570 lines", data.size(), is(570));
  }

  @Test
  public void testReadDataStripHeader() throws Exception {
    final List<String> data = DataReader.readDataStripHeader();
    Assert.assertThat("Should be 38 lines", data.size(), is(38));
    Assert.assertTrue("Third row should start with 'Akershus,male'", data.get(2).startsWith("Akershus,male"));
    Assert.assertTrue("Last row should end with '286400,301300'", data.get(37).endsWith("286400,301300"));
  }

  @Test
  public void testDecodeLinesUsingForEach() throws Exception {
    List<IncomeStatistics> statistics = DataReader.decodeLinesUsingForEach();

    Assert.assertThat("Statistics contains 38 elements", statistics.size(), CoreMatchers.is(570));
    Assert.assertThat("thirtieth element is from Akershus", statistics.get(30).county, CoreMatchers.is("Akershus"));
    Assert.assertThat("Gender of first element is male", statistics.get(0).sex, CoreMatchers.is(Gender.male));
    Assert.assertThat("Last element is from Finnmark", statistics.get(569).county, CoreMatchers.is("Finnmark"));
    Assert.assertThat("Gender of last element is female", statistics.get(569).sex, CoreMatchers.is(Gender.female));
    Assert.assertThat("Income for Vestfold, female, 1997 is 132400", statistics.get(195).averageIncome, CoreMatchers.is(132400));
    Assert.assertThat("Income for Vestfold, female, 2011 is 281900", statistics.get(209).averageIncome, CoreMatchers.is(281900));
  }
}
