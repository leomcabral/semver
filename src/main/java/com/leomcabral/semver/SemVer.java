package com.leomcabral.semver;

/**
 *
 * @author v7ji
 */
public class SemVer implements Comparable<SemVer>{

    private final int major;
    private final int minor;
    private final int patch;

    public SemVer(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    public SemVer(String version) {
        String[] split = version.split("\\.");

        if (split.length < 3) {
            throw new IllegalArgumentException("Must follow a semantic versioning value like '1.0.2'");
        }

        this.major = Integer.parseInt(split[0]);
        this.minor = Integer.parseInt(split[1]);
        this.patch = Integer.parseInt(split[2]);
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

    public String getVersion() {
        return this.major + "." + this.minor + "." + this.patch;
    }

    @Override
    public int compareTo(SemVer other) {
        int[] v1 = new int[] {major, minor, patch};
        int[] v2 = new int[] {other.getMajor(), other.getMinor(), other.getPatch()};

        int comparison = 0;

        for(int i = 0; comparison == 0 && i < v1.length; i++) {
            if (v1[i] > v2[i]) {
                comparison = 1;
            } else if (v1[i] < v2[i]) {
                comparison = -1;
            }
        }
        return comparison;
    }

}
