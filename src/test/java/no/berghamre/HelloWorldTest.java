package no.berghamre;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HelloWorldTest {

  @Test
  public void helloWorld() {
    assertThat("Should never fail", true, is(true));
  }
}
