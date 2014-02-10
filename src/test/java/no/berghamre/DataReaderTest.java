package no.berghamre;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class DataReaderTest {

  @Test
  public void readFromFile(){
    final List<String> data = DataReader.readData();
    Assert.assertThat("Should be 39 lines", data.size(), is(39));
  }

    @Test
    public void testReadDataStripHeader() throws Exception {
        final List<String> data = DataReader.readDataStripHeader();
        Assert.assertThat("Should be 38 lines", data.size(), is(38));
        Assert.assertTrue("Third row should start with 'Akershus,male'", data.get(2).startsWith("Akershus,male"));
        Assert.assertTrue("Last row should end with '286400,301300'", data.get(37).endsWith("286400,301300"));
    }
}
