package com.teragrep.bor_01.aip.pdi;

import com.teragrep.bor_01.NamespacedJsonable;

import java.time.Instant;

public interface Provenance extends NamespacedJsonable {
    Instant epochArchived();
    String processingId();
    // TODO: obj-01 processing log? processingId might be enough
    // TODO: client certificate?
}
