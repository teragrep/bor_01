package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.NamespacedJsonable;
import com.teragrep.bor_01.TimeWindow;
import com.teragrep.bor_01.aip.BloomFilter;

import java.util.Set;
import java.util.UUID;

public interface Reference extends NamespacedJsonable {
    TimeWindow timeWindow();
    String configurationItem();
    String sourceSystem();
    Set<BloomFilter> bloomFilters();
    UUID id();
}
