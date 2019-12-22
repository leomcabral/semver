package com.leomcabral.semver;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author Leonardo de M. Cabral
 */
public class SemVerTest {

    @ParameterizedTest
    @CsvSource({
        "0.0.1, 0.0.2",
        "0.1.0, 0.2.0",
        "1.0.0, 2.0.0",
        "0.1.1, 0.1.2",
        "1.1.1, 1.1.2"
    })
    @DisplayName("V1 is lower than V2")
    public void v1LowerV2(String v1, String v2) {
      SemVer semVer1 = SemVer.of(v1);
      SemVer semVer2 = SemVer.of(v2);
      assertThat(semVer1.compareTo(semVer2), is(-1));
    }

  @ParameterizedTest
  @CsvSource({
      "0.0.2, 0.0.1",
      "0.2.0, 0.1.0",
      "2.0.0, 1.0.0",
      "0.1.2, 0.1.1",
      "1.1.2, 1.1.1"
  })
  @DisplayName("V1 is greater than V2")
  public void v1GreaterV2(String v1, String v2) {
    SemVer semVer1 = SemVer.of(v1);
    SemVer semVer2 = SemVer.of(v2);
    assertThat(semVer1.compareTo(semVer2), is(1));
  }

    @Test
    @DisplayName("Can sort versions")
    public void testSort() {
        String[] vers = new String[] {
            "1.7.3", "4.1.123", "1.1.1", "2.65.4", "4.1.1"
        };

        String[] expected = new String[] {
            "1.1.1", "1.7.3", "2.65.4", "4.1.1", "4.1.123"
        };

        Arrays.sort(vers);
        assertThat(vers, arrayContaining(expected));
    }

    @Test
    @DisplayName("Can get the version")
    public void testGetVersion() {
        SemVer sv = new SemVer("2.4.3");
        assertThat(sv.getVersion(), is("2.4.3"));
    }
}
