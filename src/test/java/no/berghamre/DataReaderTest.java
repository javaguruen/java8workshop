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
}
