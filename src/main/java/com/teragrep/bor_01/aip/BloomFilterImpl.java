package com.teragrep.bor_01.aip;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;

public final class BloomFilterImpl implements BloomFilter {
    private static final Comparator<BloomFilter> comparator = Comparator
            .comparing(BloomFilter::regexPattern, Comparator.comparing(Pattern::toString))
            .thenComparing(BloomFilter::expectedElements,  Comparator.naturalOrder())
            .thenComparing(BloomFilter::targetFalsePositiveProbability,  Comparator.naturalOrder())
            .thenComparing(BloomFilter::filterBytes, Arrays::compare);
    private final byte[] filterBytes;
    private final Pattern regexPattern;
    private final long expectedElements;
    private final double targetFalsePositiveProbability;
    private static final String namespace = BloomFilterImpl.class.getName();

    public BloomFilterImpl(final byte[] filterBytes, final Pattern regexPattern, final long expectedElements, final double targetFalsePositiveProbability) {
        this.filterBytes = filterBytes;
        this.regexPattern = regexPattern;
        this.expectedElements = expectedElements;
        this.targetFalsePositiveProbability = targetFalsePositiveProbability;
    }

    @Override
    public byte[] filterBytes() {
        return filterBytes;
    }

    @Override
    public Pattern regexPattern() {
        return regexPattern;
    }

    @Override
    public long expectedElements() {
        return expectedElements;
    }

    @Override
    public double targetFalsePositiveProbability() {
        return targetFalsePositiveProbability;
    }

    @Override
    public JsonObject asJsonObject() {
        return Json.createObjectBuilder()
                .add("namespace", namespace)
                .add("filterBytes", Base64.getEncoder().encodeToString(filterBytes))
                .add("regexPattern", regexPattern.toString())
                .add("expectedElements", expectedElements)
                .add("targetFalsePositiveProbability", targetFalsePositiveProbability)
                .build();
    }

    @Override
    public int compareTo(final BloomFilter o) {
        return comparator.compare(this, o);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BloomFilterImpl that = (BloomFilterImpl) o;
        return expectedElements == that.expectedElements && Double.compare(targetFalsePositiveProbability, that.targetFalsePositiveProbability) == 0 && Objects.deepEquals(filterBytes, that.filterBytes) && Objects.equals(regexPattern, that.regexPattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(filterBytes), regexPattern, expectedElements, targetFalsePositiveProbability);
    }

    @Override
    public String namespace() {
        return namespace;
    }
}
