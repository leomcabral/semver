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
        if (this.major > other.getMajor()) {
            return 1;
        } else if (this.major < other.getMajor()) {
            return -1;
        } else {
            if (this.minor > other.getMinor()) {
                return 1;
            } else if (this.minor < other.getMinor()) {
                return -1;
            } else {
                if (this.patch > other.getPatch()) {
                    return 1;
                } else if (this.patch < other.getPatch()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

}
