package com.teragrep.bor_01;

import java.time.Duration;
import java.time.Instant;

public interface TimeWindow extends NamespacedJsonable {
    Instant startTime();
    Duration duration();
}
