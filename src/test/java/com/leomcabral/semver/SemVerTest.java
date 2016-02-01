package com.leomcabral.semver;

import java.util.Arrays;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author v7ji
 */
public class SemVerTest {

    public SemVerTest() {
    }

    @Test
    public void testCompareToOtherGreather() {
        String[][] versions = new String[][] {
            new String[] { "0.0.1", "0.0.2" },
            new String[] { "0.1.0", "0.2.0" },
            new String[] { "1.0.0", "2.0.0" },
            new String[] { "0.1.1", "0.1.2" },
            new String[] { "1.1.1", "1.1.2" }
        };

        for (int i = 0; i < versions.length; i++) {
            String[] version = versions[i];
            SemVer semVer1 = new SemVer(version[0]);
            SemVer semVer2 = new SemVer(version[1]);

            assertThat(String.format("Fail on check of v1=%s and v2=%s", version[0], version[1]), semVer1.compareTo(semVer2), is(-1));
        }
    }

    @Test
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
    public void testGetVersion() {
        SemVer sv = new SemVer("2.4.3");
        assertThat(sv.getVersion(), is("2.4.3"));
    }
}
