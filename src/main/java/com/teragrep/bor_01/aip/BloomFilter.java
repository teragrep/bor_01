package com.teragrep.bor_01.aip;

import com.teragrep.bor_01.NamespacedJsonable;
import com.teragrep.bor_01.Namespaceable;

import java.util.regex.Pattern;

public interface BloomFilter extends NamespacedJsonable, Comparable<BloomFilter>, Namespaceable {
    byte[] filterBytes();
    Pattern regexPattern();
    long expectedElements();
    double targetFalsePositiveProbability();
}
